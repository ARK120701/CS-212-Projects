public class  IllegalDate212Exception extends IllegalArgumentException{

    public IllegalDate212Exception(String message) {
        super (message);
     }
  
  /** 
   * @return String
   * prints out message 
   */
  public String getMessage(){
    return "is an Invalid Date";
  }

}