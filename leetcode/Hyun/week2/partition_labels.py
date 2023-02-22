class Solution:
    def partitionLabels(self, s: str) -> List[int]:

        idx = -1
        ans = []
        while idx < len(s) - 1:
            idx += 1
            start = idx
            ridx = s.rfind(s[idx])

            while idx < ridx:
                ridx = max(s.rfind(s[idx]), ridx)  
                idx += 1
            ans.append(ridx - start + 1)

        return ans