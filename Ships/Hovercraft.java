public class Hovercraft extends Ship{
    @Override
    public void setSize(int aDifferentSize) {
        super.setSize(aDifferentSize);
        aDifferentSize = 2;
    }

    public int getSize()
    {return size;}
}