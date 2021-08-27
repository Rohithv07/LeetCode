class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        #li = []
        #for i in range(numRows):
         #   if i == 0:
          #      li.append([1])
           # else:
            #    new_li = []
             #   for j in range(i+1):
              #      if j == 0 or j == i:
              #          new_li.append(1)
               #     else:
                #        new_li.append(li[i-1][j-1]+li[i-1][j])
                #li.append(new_li)
                
        #return li
    
    
    # Use formula C = int(C*(i-j)/j)
    
        li = []
        for i in range(1, numRows+1):
            c = 1
            new_li = []
            for j in range(1, i+1):
                new_li.append(c)
                c = int(c*(i-j)/j)
            li.append(new_li)
        return li
