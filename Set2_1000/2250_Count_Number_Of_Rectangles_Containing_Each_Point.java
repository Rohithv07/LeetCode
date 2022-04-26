class Solution {
    
	// helper fxn for binary search
    int binsear(ArrayList<Integer> arr, int x){
        int l=0, r=arr.size()-1;
        
        int anstillnow=arr.size(); 
		// if we find no m such that arr[m]>=x, means that our x is greater than all values of length, in such case we return idx n (i.e. size of arr)
		// reason being, we substract our idx by size of arr to get number of rectangles greater than that in main fxn, so return arr.size would give us 0 (which we want)
		
        while(l<=r){
            int m= l + (r-l)/2;
            
            
            if(arr.get(m)>=x){
                anstillnow=m;
                r=m-1;
            }
            else{
                l=m+1;
            }
            
        }
        
        return anstillnow;
    }
    
    public int[] countRectangles(int[][] rect, int[][] points) {
        HashMap<Integer, ArrayList<Integer>> htl= new HashMap<>();
        // maps heights to all the lengths of rectangles with that height
        
        for(int i=0; i<rect.length; i++){       
            if(htl.containsKey(rect[i][1])) htl.get(rect[i][1]).add(rect[i][0]);
            else 
            {
                htl.put(rect[i][1],new ArrayList<>());
                htl.get(rect[i][1]).add(rect[i][0]);
            }
        }
        
		// have to sort the container to apply binary search
        for(int a:htl.keySet()){
            Collections.sort(htl.get(a));        
        }
		
        int[] ans = new int[points.length];
		
        for(int i=0;i<points.length;i++){
            int x=points[i][0], y=points[i][1];
            int ct=0;
            for(int j= y; j<=100; j++){
                if(htl.containsKey(j)){
                    ct+= htl.get(j).size()- binsear(htl.get(j), x);
					// binary search return the idx in array from which the values are >= x
					// the values at this and right of this are the lengths possible
					// so substract by size of array to get the number
                }
            }
            
            ans[i]=ct;
            
        }
        
        return ans;        
    }
}