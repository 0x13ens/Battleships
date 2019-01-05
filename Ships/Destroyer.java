public class Destroyer extends Ship{

    String name = "Destroyer";

    public Destroyer(){
        name = "Destroyer";
    }

    @Override
    public void setSize(int aDifferentSize) {
        super.setSize(aDifferentSize);
        aDifferentSize = 4;
    }
}