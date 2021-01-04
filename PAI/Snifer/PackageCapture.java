import java.util.*;
import org.jnetpcap.Pcap;
import org.jnetpcap.PcapIf;
import org.jnetpcap.packet.*;
import org.jnetpcap.packet.format.FormatUtils;
import org.jnetpcap.protocol.network.Ip4;

public class PackageCapture {
    private final List<PcapIf> allDevices;
    private final PacketHandler handler;
    private final StringBuilder errbuf;
    final int snaplen = Pcap.DEFAULT_SNAPLEN;
    final int promisc = Pcap.MODE_PROMISCUOUS;
    final int timeout = 20 * 1000;

    final int captureNum = Pcap.LOOP_INFINITE;
    public PackageCapture (){
        allDevices = new ArrayList<>();
        errbuf = new StringBuilder();
        handler = new PacketHandler();
    }

    public static void main(String[] args) {
        PackageCapture  sniffer = new PackageCapture();
        List<PcapIf> devicesList=sniffer.findDevices(sniffer.getList(),sniffer.getError());
        int statusCode = sniffer.chooseDevice(devicesList);
        if(statusCode == -1) {
            return;
        }
        while(true) {
            Pcap pcap = sniffer.openSnifferSession(sniffer.getList().get(statusCode));
            if(pcap == null) break;
            pcap.loop(sniffer.getCaptureNum(), sniffer.getHandler().getPacket(), sniffer.getList().get(statusCode).getName());
        }
    }

    public List<PcapIf> findDevices(List<PcapIf> alldevs, StringBuilder error){
        int r = Pcap.findAllDevs(alldevs, error);
        if (r != Pcap.OK || alldevs.isEmpty()) {
            System.err.println("Nie mozna wczytac listy urzadzen blad: "+ error.toString());
            return null;
        }
        return alldevs;
    }


    public int chooseDevice(List<PcapIf> devices){
        for(PcapIf device : devices){
            System.out.println(devices.indexOf(device)+" "+device.getName() + " " + device.getAddresses());
        }
        System.out.print("Wybierz urzadzenie:");
        int choice = new Scanner(System.in).nextInt();
        if(choice < 0 || choice >= devices.size()){
            System.out.println("Nie ma takiego urzadzenia");
            return -1;
        }
        return choice;
    }



    public Pcap openSnifferSession(PcapIf device){
        Pcap pcap = Pcap.openLive(device.getName(), snaplen, promisc, timeout, errbuf);
        if (pcap == null) {
            System.err.println("Blad "+ errbuf.toString());
            return null;
        }
        return pcap;
    }

    public PacketHandler getHandler(){
        return handler;
    }
    public List<PcapIf> getList(){
        return allDevices;
    }
    public StringBuilder getError(){
        return errbuf;
    }
    public int getCaptureNum(){
        return captureNum;
    }
}



class PacketHandler {
    private final PcapPacketHandler<String> packet;

    public PacketHandler() {
        packet = new PcapPacketHandler<String>() {
            @Override
            public void nextPacket(PcapPacket packet, String user) {
                Ip4 ip = new Ip4();
                if (!packet.hasHeader(ip)) {
                    return;
                }
                String IPSource = FormatUtils.ip(ip.source());
                String IPDestination = FormatUtils.ip(ip.destination());

                System.out.println("Received packet at "+ new Date(packet.getCaptureHeader().timestampInMillis())
                        +" packet length="+packet.getCaptureHeader().wirelen()
                        +" "+IPSource+" "+IPDestination);
            }
        };

    }

    public PcapPacketHandler<String> getPacket() {
        return packet;
    }
}