package interview;// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class HelloWorld {

  public static void main(String[] args) {
//Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
//  Input: nums = [1,1,2]
//  Output:
//  [[1,1,2],
//  [1,2,1],
//  [2,1,1]]

//Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),return the number of islands.
// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
// Example 1:
// Input: grid = [
//   ["1","1","1","1","0"],
//   ["1","1","0","1","0"],
//   ["1","1","0","0","0"],
//   ["0","0","0","0","0"]
// ]
// Output: 1

// Example 2:
// Input: grid = [
//   ["1","1","0","0","0"],
//   ["1","1","0","0","0"],
//   ["0","0","1","0","0"],
//   ["0","0","0","1","1"]
// ]
// Output: 3

    String[][] grid = {
        {"1", "1", "1", "1", "0"},
        {"1", "1", "0", "1", "0"},
        {"1", "1", "0", "0", "0"},
        {"0", "0", "0", "0", "0"}
    };
    // {
    //   {"00","01","02","03","04"},
    //   {"10","11","12","13","14"},
    //   {"1","1","0","0","0"},
    //   {"0","0","0","0","0"}
    // };

//    int islandCount = 0;
//    String[][] gridCopy = new int[grid.length][grid[0].length];
//    for(int i=0;i<grid.length;i++){
//        for(int j=0;j<grid[0].length;j++){
//            gridCopy[i][j] = grid[i][j];
//        }
//    }
//
//    for(int i=0;i<gridCopy.length;i++){
//        for(int j=0;j<gridCopy[0].length;j++){
//
//        }
//    }
//    // List<Integer> perm(List<Integer> input){
//    //     if(arr.size() == 1)
//    //         return input;
//
//    //     int fixed = input.get(0);
//    //     input.remove(0);
//    //     perm(input);
//    // }
//
//    //row=1 and col=1
//    public void explore(int[][] arr,int row,int col){
//        if(arr[row][col] == "0" || row<0 || row>=arr.length || col<0 || col>=arr[0].length){
//            return;
//        }
//        //go left and mark elements as visited
//        for(int j=col-1;j>=0;j--){
//            //  if(j<0 || j>=arr.length){
//            //      break;
//            //  }
//          if (arr[row][j] == "1") {
//            arr[row][j] = "V";
//          } else {
//            break;
//          }
//        }
//        //go right and mark elements as visited
//        for(int j=col+1;j<arr.length;j++){
//            //  if(j<0 || j>=arr.length){
//            //      break;
//            //  }
//          if (arr[row][j] == "1") {
//            arr[row][j] = "V";
//          } else {
//            break;
//          }
//        }
//        //go down and mark elements as visited
//        for(int i=row+1;i<arr.length;i++){
//            //  if(j<0 || j>=arr.length){
//            //      break;
//            //  }
//          if (arr[i][col] == "1") {
//            arr[i][col] = "V";
//          } else {
//            break;
//          }
//        }
//        //go up and mark elements as visited
//        for(int i=row-1;i>=0;i--){
//          if (arr[i][col] == "1") {
//            arr[i][col] = "V";
//          } else {
//            break;
//          }
//        }
  }

}