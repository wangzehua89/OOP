class lecturer extends person{
    public lecturer(String name,String id){
        super(name,id);
    }
    public void introduce(){
        System.out.println("I am a lecturer.");
    }
}