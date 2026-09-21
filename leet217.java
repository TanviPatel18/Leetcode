
import java.util.HashSet;
public class leet217 {
    
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums)
            if (!set.add(num))
                return true;

        return false;
    }
    public static void main(String[] args) {
        leet217 obj= new leet217();
        int[] nums={1,2,3,1};
        System.out.println(obj.containsDuplicate(nums));
    }
    
}
