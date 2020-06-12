
int removeDuplicates(int* nums, int numsSize){
    int i,j;
    j=0;
    for(i=0;i<numsSize-1;i++){
        nums[i]!=nums[i+1]?nums[++j]=nums[i+1]:0;
    }
    return numsSize?j+1:0;
        

}

