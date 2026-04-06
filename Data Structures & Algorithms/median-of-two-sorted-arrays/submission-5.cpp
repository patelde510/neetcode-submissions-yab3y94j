class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        vector<int>& A = nums1;
        vector<int>& B = nums2;
        int total = A.size() + B.size();
        int half = (total + 1) / 2;

        if (B.size() < A.size()) {
            swap(A, B);
        }

        int l = 0;
        int r = A.size();

        while (l <= r) {
            int mA = (l + r) / 2;
            int mB = half - mA;

            int Aleft = mA >0 ? A[mA-1] : INT_MIN; 
            int Aright = mA < A.size() ? A[mA] : INT_MAX;
            int Bleft = mB > 0 ? B[mB-1] : INT_MIN;
            int Bright = mB < B.size() ? B[mB] : INT_MAX;

            if (Aleft <= Bright && Bleft <= Aright) {
                if (total % 2 != 0) {
                    return max(Aleft, Bleft);
                } else {
                    return (max(Aleft, Bleft) + min(Aright, Bright)) / 2.0;
                }
            } else if (Aleft > Bright) {
                r = mA - 1;
            } else {
                l = mA + 1;
            }
        }
        return -1;
    }
};
