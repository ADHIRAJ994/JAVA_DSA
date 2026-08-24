import java.util.HashSet;

public class AllOccuranceOfUniqueChar {
    void AllOccurance(String str,int idx,String NewString,HashSet<String>set){
        if(idx == str.length()){
            if(set.contains(NewString)){
                return;
            }else{
                System.out.println(NewString);
                set.add(NewString);
                return;
            }
            
        }
        char CurrenChar = str.charAt(idx);
        //To be added
        AllOccurance(str, idx+1, NewString+CurrenChar,set);
        // To be not Added
        AllOccurance(str, idx+1, NewString,set);

    }

    public static void main(String[] args) {
        AllOccuranceOfUniqueChar obj = new AllOccuranceOfUniqueChar();
        String str = "123";
        HashSet<String> set = new HashSet<>();
        obj.AllOccurance(str, 0, "",set);
        
    }
}


