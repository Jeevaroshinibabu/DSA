class Solution:
    def maximumGap(self, nums: List[int]) -> int:
        a=sorted(nums)
        b=0
        for i in range(1,len(a)):
            c=a[i]-a[i-1]
            b=max(b,c)
        return b