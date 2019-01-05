import java.util.Random;


public class Board {

    private int space[][] = new int[10][10];
    private Random rand;
    boolean bTryingtoPlace;
    int direction;
    int checkedBoardXpositionStart, checkedBoardXPositionEnd;
    int checkedBoardYPositionStart, checkedBoardYPositionEnd;
    boolean bThereisRoom;


    public Board()
    {
        //when a car park object is initially created, make sure that all the spaces have an "E" for empty
        for(int i = 0; i< 9; i++)
        {
            for( int j = 0; j<9; j++)
            {
                space[i][j] = 0;
            }
        }
        
        //initialise our random number generator
        rand = new Random();
        bTryingtoPlace = false;
        bThereisRoom = false;
        
        //we will use x and y to reference the 5x5 grid coordinates where x is horizontal and y is vertical
        //we will also use 0-direction for a horizontal placement and 1-direction for a vertical placement
        direction = 0;checkedBoardXpositionStart = 0;checkedBoardYPositionStart = 0;

        //the below helps us to see whether we can fit a whole vehicle in to the allocated spaces!
         checkedBoardXPositionEnd = 0; checkedBoardYPositionEnd = 0;
    }

    public void DisplayBoardSpaces()
    {
        for(int i = 0; i< 10; i++)
        {
            for( int j = 0; j<10; j++)
            {
                System.out.print(space[j][i]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    //this next method is NOT optimised and NOT the most efficient way of doing this, however it is a demonstration
    //using step by step logic.  Ideally this method would be broken down into smaller methods too.
    public void PlaceShip(int lengthOfShip)
    {

        bTryingtoPlace = true;

        while(bTryingtoPlace == true)
        {
            //rand returns a number of zero to four which matches the index locations of our CarPark array
            checkedBoardXpositionStart = rand.nextInt(9);
            checkedBoardYPositionStart = rand.nextInt(9);

            checkedBoardXPositionEnd = checkedBoardXpositionStart;
            checkedBoardYPositionEnd = checkedBoardYPositionStart;
            
            //rand will return either a one or a zero so will randomly choose a direction
            direction = rand.nextInt(2);

            //lets check to see whether these randomly placed vehicle coordinates are viable in that they
            //won't mean that a car is half sitting outside of the carpark grid:

            //if the direction is horizontal find out what the end position will be based on the size of the car
            if(direction == 0)
            {
                checkedBoardXPositionEnd = checkedBoardXpositionStart + (lengthOfShip - 1);
            }
            else
            {
                //if the direction is not zero, it must be one so the direction is vertical.  Find out what the end
                //position of the vertically placed car will be
                checkedBoardYPositionEnd = checkedBoardYPositionStart + (lengthOfShip - 1);
            }
            //now make sure that these positions are not over extending the grid, and if they are, start all over again
            if(checkedBoardXPositionEnd>9 || checkedBoardYPositionEnd>9)
            {
                //if either of the (remember '||' is 'OR') endpoint car positions are a number greater than the
                // zero to four positions we have in our 5x5 grid:
                //start the loop at the beginning again with all conditions reset, including the loop's initialisation
                // condition - the true false bit!
                // **PLEASE BE AWARE THIS IS NOT THE WAY WE WOULD DO IT IN INDUSTRY**
                continue;
            }
            //if the positions created are valid and won't over extend the grid, we now need to check for spaces in the
            //garage.  We will split the logic in to two -
            // a check for horizontal placement chosen
            // and one for vertical placement chosen
            // the logic however is the same and could potentially be combined or we could create two methods from it

            //if the car is being placed HORIZONTALLY
            if(direction == 0)
            {
                int noOfSpaces =0;
                for(int i = checkedBoardXpositionStart; i<(checkedBoardXPositionEnd+1); i++)
                {
                    if(space[i][checkedBoardYPositionStart]!= 0)
                    {
                        i = checkedBoardXPositionEnd+1;
                        bThereisRoom=false;
                        noOfSpaces =0;
                    }
                    else
                    {
                        noOfSpaces++;
                    }

                    //did we manage to loop through the size of the car and count enough empty space in the
                    //same direction
                    if(noOfSpaces == lengthOfShip)
                    {
                        //then there must be room to place a car
                        bThereisRoom = true;
                        //reset the count for next time around
                        noOfSpaces = 0;
                    }
                }

                //if we managed to find enough room then fill the car spaces up with the size of the car
                if(bThereisRoom == true)
                {
                    //fill the car park array with letters to represent the length of the car
                    for(int j = checkedBoardXpositionStart; j<(checkedBoardXPositionEnd+1); j++)
                    {
                        space[j][checkedBoardYPositionStart]= 1;
                        System.out.println("Horizontal: x: "+j+" y: "+checkedBoardYPositionStart);
                    }
                    //reset the spacefinder back to false for when the next vehicle needs to be checked
                    bThereisRoom = false;
                    //reset the parking method ready for use again for another vehicle
                    bTryingtoPlace = false;
                }
            }
            else
            {
                int noOfSpaces =0;
                //the car must be being placed VERTICALLY
                for(int k = checkedBoardYPositionStart; k<checkedBoardYPositionEnd+1; k++)
                {

                    if(space[checkedBoardXpositionStart][k]!= 0)
                    {
                        k = checkedBoardYPositionEnd+1;
                        bThereisRoom=false;
                        noOfSpaces = 0;
                    }
                    else
                    {
                        noOfSpaces++;
                    }

                    //did we manage to loop through the size of the car and count enough empty space in the
                    //same direction
                    if(noOfSpaces == lengthOfShip)
                    {
                        //then there must be room to place a car
                        bThereisRoom = true;
                        //reset the count for next time around
                        noOfSpaces = 0;
                    }
                }

                //if we managed to find enough room then fill the car spaces up with the size of the car
                if(bThereisRoom == true)
                {
                    //fill the car park array with letters to represent the length of the car
                    for(int m = checkedBoardYPositionStart; m< checkedBoardYPositionEnd+1; m++)
                    {
                        space[checkedBoardXpositionStart][m]= 1;
                        System.out.println("Vertical: x: "+checkedBoardXpositionStart+" y: "+m);
                    }
                    //reset the spacefinder back to false for when the next vehicle needs to be checked
                    bThereisRoom = false;
                    //reset the parking method ready for use again for another vehicle
                    bTryingtoPlace = false;
                }
            }
        }

    }
}