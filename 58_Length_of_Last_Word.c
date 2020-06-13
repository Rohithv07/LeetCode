int lengthOfLastWord(char * s){
    int i;
    int count = 0;
    
    for(i = strlen(s)-1; i >= 0; i--){
        if(s[i] == ' '){
            if(count != 0)
                return count;
            count = 0;
        }
        else
            count ++;
           
    }
    return count;
}
