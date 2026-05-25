class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        l, r = 0, len(matrix)-1

        while l < r:
            for i in range(r-l):
                top, bottom = l, r
                # Save top left
                topLeft = matrix[top][l+i]

                # Set top left to bottom left
                matrix[top][l+i] = matrix[bottom-i][l]

                # Set bottom left to bottom right
                matrix[bottom-i][l] = matrix[bottom][r-i]

                # Set bottom right to top right
                matrix[bottom][r-i] = matrix[top+i][r]

                # Set top right to to top left (Saved value)
                matrix[top+i][r] = topLeft

            l += 1
            r -= 1


