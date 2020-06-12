int reverse(long int x){
   long int rev=0,rem;
    if(x<0){
            if(x<pow(-2,31)){
                return 0;
            }
        else{
            x=x*-1;
            while(x>0){
                rem=x%10;
                rev=rev*10+rem;
                x=x/10;
            }
            rev=rev*-1;
            if(rev<pow(-2,31))
                return 0;
            else
                return rev;
        
    }
    }
    else{
            if(x>pow(2,31)){
                return 0;
            }
        else{
            while(x>0){
                rem=x%10;
                rev=rev*10+rem;
                x=x/10;
            }
           if(rev>pow(2,31))
               return 0;
        else
            return rev;
        }
    }
    }
