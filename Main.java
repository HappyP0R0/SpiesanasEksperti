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
    //dummy text - 1p Lorem
    String dummy_text= /*"WYS*WYGWYS*WYSWYSG"; */"your compression is your impression by depression.";
    String val = LZW.encode(dummy_text);
    LZW.decode(val);
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
  public static void main(String[] args) {
    String val = "encode";
    if (val == "encode") {
      SpiesanasEksperti.encode("filename");
    } else if (val == "decode") {
      SpiesanasEksperti.decode("filename");
    }

  }
}