public class MenuSizes {
    
    private final String food;
    private final double sizeOne;
    private final double sizeTwo;
    private final double sizeThree;
    private final double sizeFour;
    
    public String getName(){
        return food;
    }
    
    public double getSizeOne(){
        return sizeOne;
    }
    
    public double getSizeTwo(){
        return sizeTwo;
    }
    
    public double getSizeThree(){
        return sizeThree;
    }
    
    public double getSizeFour() {
        return sizeFour;
    }

    public MenuSizes(String food, double sizeOne, double sizeTwo, double sizeThree, double sizeFour) {
        this.food = food;
        this.sizeOne = sizeOne;
        this.sizeTwo = sizeTwo;
        this.sizeThree = sizeThree;
        this.sizeFour = sizeFour;
    }
}
