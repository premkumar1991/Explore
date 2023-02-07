import java.util.HashSet;

public class Given {
    private int value;
    public Given(int value){
        this.value=value;
    }
    public Given add(int value){
        this.value+=value;
        return this;
    }
    public Given mutiply(int value){
        this.value*=value;
        return this;
    }
    public int output(){
        return this.value;
    }

    public int[] shuffle(int[] nums){
        int left=0;
        int right=nums.length-1;

        while (left<right){
            if(nums[left]>=0&&nums[right]<0){
                int temp=nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
            }
            left++;
            right--;
        }
        return nums;
    }

    



}

//


// -2 -1 2 1 3

// Select id,name from SCORE Sort by rank limit(0,n)
// sql[n-1]


//Student {
//    id:int,
//    name:string
//    subject_id:id
//}
//
//subject {
//    id:
//}
//
//id  subject_id
//1      3
//1      4
//
//Profile
//




