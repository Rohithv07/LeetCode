
bool isPalindrome(long int x){
    long int temp,rev=0,rem;
    if(x<0)
        return false;
    else{
        temp=x;
        while(x>0){
            rem=x%10;
            rev=rev*10+rem;
            x=x/10;
        }
        if(temp==rev)
            return true;
        else
            return false;
        }

}

