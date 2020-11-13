
import java.util.Comparator;
import java.util.Random;

public class Tree {

    private Typist root;
    private PersonWithTheBestKeyboard comparator;
    String[] files = new String[]{"a.txt", "b.txt", "c.txt", "d.txt", "e.txt"};
    String[] names = new String[]{"Ala", "Ola", "Paweł", "Agata", "Daria", "Patryk", "Piotr", "Kacper", "Patrycja", "Aleksandra", "Beata", "Marcin", "Kamil", "Adrian"};
    String[] surnames = new String[]{"Nowak", "Wojcik", "Wozniak", "Wrobel", "Zajac", "Stepien", "Wilk", "Lis", "Kowalczyk", "Lipa", "Marzec", "Kwiecien", "Maj"};

    public static void main(String args[]) {

        System.out.println("-------------------------Pierwsze porownanie:-------------------------");
        Tree firstTree = new Tree(new PersonWithTheBestKeyboard());
        firstTree.generate(30);
        firstTree.removePersonByKeyboard(firstTree.getRoot());
        firstTree.printAscending(1);
        System.out.println("\n\n---------------------Drugie porownanie--------------------------");
        Tree secondTree = new Tree();
        secondTree.generate(30);
        secondTree.removePersonByPoints(secondTree.getRoot());
        secondTree.printAscending(0);
    }

    public Tree(Comparator<Typist> comp) {
        root = null;
        comparator = (PersonWithTheBestKeyboard) comp;
    }

    public Tree() {
        root = null;
        comparator = null;
    }

    public Typist getRoot() {
        return leftMost(root);
    }
    static Typist leftMost(Typist root) {
        if (root == null) {
            return null;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    Keyboard generateKeyboard() {
        Random r = new Random();
        int choice = r.nextInt(3);
        Type typeOfKeyboard = Type.MECHANICAL;
        switch (choice) {
            case 0:
                typeOfKeyboard = Type.MECHANICAL;
                break;
            case 1:
                typeOfKeyboard = Type.HYBRID;
                break;
            case 2:
                typeOfKeyboard = Type.MEMBRANE;
                break;
            default:
                break;
        }
        Keyboard key = new Keyboard(typeOfKeyboard, r.nextInt(10), r.nextInt(10), r.nextInt(250) + 100);
        return key;
    }

    public void generate(int count) {
        Random r = new Random();
        if (comparator != null) {
            for (int i = 0; i < count; i++) {
                Keyboard key = generateKeyboard();
                insertByKeyboard(names[r.nextInt(13)], surnames[r.nextInt(13)], files[r.nextInt(4)], r.nextInt(101) + 10, key);
            }
        } else {
            for (int i = 0; i < count;) {
                Keyboard key = generateKeyboard();
                int res = insertByPoints(names[r.nextInt(13)], surnames[r.nextInt(13)], files[r.nextInt(4)], r.nextInt(101) + 10, key);
                if (res != 0) {
                    i++;
                }
            }
        }
    }

    void printAscending(int a) {
        printAsc(this.root, a);
    }

    void printAsc(Typist node, int a) {
        if (node == null) {
            return;
        }

        printAsc(node.left, a);
        node.print();
        if (a == 1) {
            node.keyboard.print();
        } else if (a == 0) {
            node.printFinalPoints();
        }
        printAsc(node.right, a);
    }

    public void insertByKeyboard(String name, String surname, String fileName, int timeInSeconds, Keyboard key) {
        if (root == null) {
            root = new Typist(name, surname, fileName, timeInSeconds, key);
            return;
        }
        Typist node = new Typist(name, surname, fileName, timeInSeconds, key);
        Typist head = root, parent = null;
        int result = 0;
        while (head != null) {
            result = comparator.compare(head, node);
            parent = head;
            if (result > 0) {
                head = head.right;
            } else {
                head = head.left;
            }
        }
        head = node;
        head.parent = parent;
        if (result > 0) {
            parent.right = head;
        } else if (result < 0) {
            parent.left = head;
        }
    }

    public int insertByPoints(String name, String surname, String fileName, int timeInSeconds, Keyboard key) {
        if (root == null) {
            root = new Typist(name, surname, fileName, timeInSeconds, key);
            return 1;
        }
        Typist node = new Typist(name, surname, fileName, timeInSeconds, key);
        Typist head = root, parent = null;
        int result = 0;
        while (head != null) {
            result = head.compareTo(node);
            if (result > 0) {
                parent = head;
                head = head.right;
            } else if (result == 0) {
                return 0;
            } else {
                parent = head;
                head = head.left;
            }
        }
        head = node;
        head.parent = parent;
        if (result > 0) {
            parent.right = head;
        } else if (result < 0) {
            parent.left = head;
        }
        return 1;
    }

    public void removePersonByKeyboard(Typist node) {
        Typist head = root;
        int result = 0;
        while (true) {
            if (comparator.compare(head, node) == 0) {
                //brak dzieci
                if (head.left == null && head.right == null) {
                    if (head.parent != null) {
                        result = comparator.compare(head.parent, head);
                        if (result > 0) {
                            head.parent.right = head = null;
                        } else if (result < 0) {
                            head.parent.left = head = null;
                        }
                    } else {
                        root = null;
                    }
                } //1 dziecko
                else if (head.left == null || head.right == null) {
                    if (head.parent != null) {
                        result = comparator.compare(head.parent, head);
                        if (result > 0) {
                            if (head.left != null) {
                                head.parent.right = head.left;
                            } else {
                                head.parent.right = head.right;
                            }
                        } else if (result < 0) {
                            if (head.left != null) {
                                head.parent.left = head.left;
                            } else {
                                head.parent.left = head.right;
                            }
                        }
                    } else {
                        if (head.left != null) {
                            root = head.left;
                        } else {
                            root = head.right;
                        }
                    }
                } //2 dzieci
                else if (head.left != null && head.right != null) {
                    Typist tempNode = findSuccessor(head);
                    if (tempNode == head.right) {
                        if (head == root) {
                            root = head.right;
                        } else {
                            head.parent.right = head.right;
                            head.parent.right.left = head.left;
                        }
                    } else if (tempNode != head.right) {
                        if (head == root) {
                            tempNode.parent.left = tempNode.right;
                            tempNode.left = root.left;
                            tempNode.right = root.right;
                            root = tempNode;

                        } else {
                            tempNode.parent.left = tempNode.right;
                            int tempResult = comparator.compare(head.parent, head);
                            if (tempResult > 0) {
                                head.parent.right = tempNode;
                                tempNode.left = head.left;
                                tempNode.right = head.right;
                            } else if (tempResult < 0) {
                                head.parent.left = tempNode;
                                tempNode.left = head.left;
                                tempNode.right = head.right;
                            }
                        }
                    }
                }
                return;
            }
            result = comparator.compare(head, node);
            if (result > 0) {
                head = head.right;
            } else if (result < 0) {
                head = head.left;
            } else {
                break;
            }

        }
    }

    public void removePersonByPoints(Typist node) {
        Typist head = root;
        int result = 0;
        while (true) {
            if (head.compareTo(node) == 0) {
                //brak dzieci
                if (head.left == null && head.right == null) {
                    if (head.parent != null) {
                        result = head.parent.compareTo(head);
                        if (result > 0) {
                            head.parent.right = head = null;
                        } else if (result < 0) {
                            head.parent.left = head = null;
                        }
                        return;
                    } else {
                        root = null;
                    }
                } //1 dziecko
                else if (head.left == null || head.right == null) {
                    if (head.parent != null) {
                        result = head.parent.compareTo(head);
                        if (result > 0) {
                            if (head.left != null) {
                                head.parent.right = head.left;
                            } else {
                                head.parent.right = head.right;
                            }
                        } else if (result < 0) {
                            if (head.left != null) {
                                head.parent.left = head.left;
                            } else {
                                head.parent.left = head.right;
                            }
                        }
                        head = null;
                    } else {
                        if (head.left != null) {
                            root = head.left;
                        } else {
                            root = head.right;
                        }
                    }
                } //2 dzieci
                else if (head.left != null && head.right != null) {
                    Typist tempNode = findSuccessor(head);
                    if (tempNode == head.right) {
                        if (head == root) {
                            root = head.right;
                        } else {
                            head.parent.right = head.right;
                            head.parent.right.left = head.left;
                        }
                        return;
                    }
                    if (tempNode != head.right) {
                        if (head == root) {
                            tempNode.parent.left = tempNode.right;
                            tempNode.left = root.left;
                            tempNode.right = root.right;
                            root = tempNode;

                        } else {
                            tempNode.parent.left = tempNode.right;
                            int tempResult = head.parent.compareTo(head);
                            if (tempResult > 0) {
                                head.parent.right = tempNode;
                                tempNode.left = head.left;
                                tempNode.right = head.right;
                            } else if (tempResult < 0) {
                                head.parent.left = tempNode;
                                tempNode.left = head.left;
                                tempNode.right = head.right;
                            }
                        }
                    }
                }
                return;
            }
            result = head.compareTo(node);
            if (result > 0) {
                head = head.right;
            } else if (result < 0) {
                head = head.left;
            } else {
                break;
            }
        }
    }

    public Typist findSuccessor(Typist toChange) {
        Typist traverseNode = toChange.right;
        while (traverseNode.left != null) {
            traverseNode = traverseNode.left;
        }
        return traverseNode;
    }
}
