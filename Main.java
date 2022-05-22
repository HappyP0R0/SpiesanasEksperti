import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.Set;
/**
 * Krišjanis Elksnītis 8.grupa 211RDB062
 * Andrejs Kopņins 8.grupa 211RDB417
 * Aleksis Oskars Strauts 8.grupa 211RDB015
 * Sandis Ivanovskis 8. grupa 211RDB359
 * Madara Golsta 8.grupa 211RDB453
 * Artis Barkovskis 8.grupa 211RDB029
 */

class LZW {
  public static String encode(String input) {
    HashMap <String, Integer> table = new HashMap<String, Integer>();
    //Values 0-255 from ASCII
    for(int i=0; i<=255; i++){
      String ch = "";
      ch = ch + (char)i;
      table.put(ch, i);
    }

    int code = 256;
    String p="", result="", c="";
    p=p + input.charAt(0);

    for(int i = 0; i<input.length(); i++){
      if(i != input.length()-1)
        c+=input.charAt(i+1);
      if(c.equals(" ")){//ja c ir " " pievieno p un " " rezultātam
        //add the space to string
        result+=(table.get(p)+ " " +table.get(" ")+" ");
        p="";
      }
      else if(c.equals("")){//ja c ir "", pievieno p rezultātam
        result+=(table.get(p));
        p="";
      }
      else if(table.containsKey(p+c) ){
        p=p+c;
      }
      else{
        result+=(table.get(p)+" "); //add 2 output
        table.put(p+c, code);
        code++;
        p=c;
      }
      c="";
    }
    return result;
  }


  public static String decode(String input) { //smth not right
    HashMap <Integer, String> table = new HashMap<Integer, String>();
    //Values 0-255 from ASCII
    for(int i=0; i<=255; i++){
      String ch = "";
      ch = ch + (char)i;
      table.put(i, ch);
    }

    //parse to int
    String[] stringArray = input.split(" ");
    int[] array = new int[stringArray.length];
    for (int i = 0; i < stringArray.length; i++) {
      array[i] = Integer.parseInt(stringArray[i]);
    }


    int old = array[0], code=256, n;
    String s=table.get(old), 
    c="", result=s;
    c+=s.charAt(0);
    for(int i=0;i<array.length-1; i++){
      n=array[i+1];
      if(n==32){
        result+=" ";
        s="";
        c="";
      }
      else if(!table.containsKey(n)){
        s=table.get(old);
        s=s+c;
        result+=s;
      }
      else{
        s=table.get(n);
        result+=s;
      }
      if(n!=32 && old!=32){
        c="";
        c+=s.charAt(0);
        table.put(code, (table.get(old)+c));
        code++;
      }
      old=n;
    }
    return input;
  }
}

class HuffmanEncoding {
  public static String encode(String input) {
    System.out.println("encode");
    return input;
  }

  public static String decode(String input) {
    System.out.println("decode");
    return input;
  }
}

class HuffmanTree {
private static Map <Character, String> map = new HashMap<>();
  static Node root;
  
  public HashMap <String, String> table;
  public HashMap <String, Integer> frequency;
  public int cutoff;
  public int maxFrequency;

  public void HuffmanTree(String[] input) {
    table = null;
    frequency = null;
    root = null;
    cutoff = 0;
    maxFrequency = 0;
    
  }
  
  public static String encode(String test) {
    Map<Character, Integer> freq = new HashMap<>();
    for (int i = 0; i < test.length(); i++) {
      if (!freq.containsKey(test.charAt(i))) {
        freq.put(test.charAt(i), 0);
      }
      freq.put(test.charAt(i), freq.get(test.charAt(i)) + 1);
    }
    root = createTree(freq);

    setPrefixCodes(root, new StringBuilder());
    StringBuilder s = new StringBuilder();

    for (int i = 0; i < test.length(); i++) {
      char c = test.charAt(i);
      s.append(map.get(c));
    }
    return s.toString();
  }

  private static void decode(String s) {
    StringBuilder stringBuilder = new StringBuilder();
    Node temp = root;
    for (int i = 0; i < s.length(); i++) {
      int j = Integer.parseInt(String.valueOf(s.charAt(i)));
      if (j == 0) {
        temp = temp.left;
        if (temp.left == null && temp.right == null) {
          stringBuilder.append(temp.data);
          temp = root;
        }
      }
      if (j == 1) {
        temp = temp.right;
        if (temp.left == null && temp.right == null) {
          stringBuilder.append(temp.data);
          temp = root;
        }
      }
    }
  }
  
  private static Node createTree(Map<Character,Integer> freq) {
    PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
    Set<Character> keySet = freq.keySet();
    for (Character str : keySet) {
      Node huffmanNode = new Node();
      huffmanNode.data = str;
      huffmanNode.frequency = freq.get(str);
      huffmanNode.left = null;
      huffmanNode.right = null;
      priorityQueue.offer(huffmanNode);
    }
    assert priorityQueue.size() > 0;

    while (priorityQueue.size() > 1) {
      Node x = priorityQueue.peek();
      priorityQueue.poll();

      Node y = priorityQueue.peek();
      priorityQueue.poll();

      Node sum = new Node();
      sum.frequency = x.frequency + y.frequency;
      sum.data = '-';

      sum.left = x;
      sum.right = y;
      root = sum;

      priorityQueue.offer(sum);
    }
    return priorityQueue.poll();
  }
    
  private static void setPrefixCodes(Node node,StringBuilder prefix) { //private void calculateFrequency() {
    if (node != null) {
      if (node.left == null && node.right == null) {
        map.put(node.data, prefix.toString());
        
      } else {
        prefix.append('0');
        setPrefixCodes(node.left, prefix);
        prefix.deleteCharAt(prefix.length() - 1);

        prefix.append('1');
        setPrefixCodes(node.right, prefix);
        prefix.deleteCharAt(prefix.length() - 1);
      }
    }
  }

  private void createTable() {
  }
  
  private String[] tableToStringArray(int frequencySize) {
    String[] vals = {"A", "B", "C"};
    return vals;
  }
  
}

class Node {
  int frequency;
  Node left, right;
  char data;

  public int compare(Node node) {
    return frequency - node.frequency;
  }

    private boolean isLeaf() {
     assert ((left == null) && (right == null)) || ((left != null) && (right != null));
     return (left == null) && (right == null);
    }

/*
  public Node(String stringData){
    data = stringData;
    binaryView = "";
    left = null;
    right = null;
    weight = 0;
  }


  public void addWeight(){
    weight++;
  }
}
*/
  
class SpiesanasEksperti {
  public static void encode(String input){
    //read file
    String dummy_text= "your compression is your impression by depression.";
    String val = LZW.encode(dummy_text);
    String HuffmanVal = HuffmanEncoding.encode(val);
    //write file
  }

  public static void decode(String input) {
    //read file
    String val = LZW.decode(input);
    String HuffmanVal = HuffmanEncoding.decode(val);
    //write file
  }
}

class Main {
  public static void main(String[] args) {
    String val = "encode";
    if (val == "encode") {
      SpiesanasEksperti.encode("filename");
    } else if (val == "decode") {
      SpiesanasEksperti.decode("filename");
    }

  }
}