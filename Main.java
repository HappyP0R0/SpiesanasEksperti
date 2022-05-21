import java.util.HashMap;
/**
 * Krišjanis Elksnītis 8.grupa 211RDB062
 * Andrejs Kopņins 8.grupa 211RDB417
 * Aleksis Oskars Strauts 8.grupa 211RDB015
 * Sandis Ivanovskis 8. grupa 211RDB359
 * Madara Golsta 8.grupa 211RDB453
 * Artis Barkovskis 8.grupa 211RDB029
 */

class LZW {
  public static String encode(String Filename) {
    System.out.println("encode");
    return Filename;
  }

  public static String decode(String Filename) {
    System.out.println("decode");
    return Filename;
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
  public HashMap<String, String> table;
  public HashMap<String, Integer> frequency;
  public Node root;
  public int cutoff;
  public int maxFrequency;

  public void HuffmanTree(String[] input){
    table = null;
    frequency = null;
    root = null;
    cutoff = 0;
    maxFrequency = 0;
    
  }
  public String[] encode(){
    String[] vals = {"C", "B", "A"};
    return vals;
  }
  private void calculateFrequency(){
    
  }
  private void createTree(){
    
  }
  private void createTable(){
    
  }
  private String[] tableToStringArray(int frequencySize){
    String[] vals = {"A", "B", "C"};
    return vals;
  }
  
}

class Node {
  public String data, binaryView;
  int weight;
  public Node right, left;

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

class SpiesanasEksperti {
  public static void encode(String Filename){
    //read file
    String val = LZW.encode(Filename);
    String HuffmanVal = HuffmanEncoding.encode(val);
    //write file
  }

  public static void decode(String Filename) {
    //read file
    String val = LZW.encode(Filename);
    String HuffmanVal = HuffmanEncoding.encode(val);
    //write file
  }
}

class Main {
  public static void main(String[] args){
   System.out.printl("Encode or decode file?") 
  {
    String val = "encode";
    if (val == "encode") {
      SpiesanasEksperti.encode("filename");
    } else if (val == "decode") {
      SpiesanasEksperti.decode("filename");
    }

  }
}
}