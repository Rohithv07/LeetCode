int *twoSum(int* nums, int numsSize, int target, int* returnSize)
{
    *returnSize = 2;
    int *returnArray = (int*) malloc(*returnSize * sizeof(int));
    
    for(int i = 0; i < numsSize; i++)
    {
        for(int j = i+1; j < numsSize; j++)
        {
            if(nums[i] == target - nums[j])
            {
                returnArray[0] = i;
                returnArray[1] = j;
                return returnArray;
            }
        }
    }
    
    return -1;
}