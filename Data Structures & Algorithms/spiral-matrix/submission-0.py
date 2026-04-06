class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        bottom = len(matrix)
        right = len(matrix[0])

        top = 0
        left = 0

        res = []

        while left < right and top < bottom:
            
            for i in range(left, right):
                res.append(matrix[top][i])

            # Increment top since we seen all the top values
            top += 1

            for i in range(top, bottom):
                res.append(matrix[i][right-1])
            
            # Decrement right since we seen all right side values
            right -= 1

            if not (left < right and top < bottom):
                break

            for i in range(right-1, left-1, -1):
                res.append(matrix[bottom-1][i])
            
            # Decrement bottom
            bottom -= 1

            for i in range(bottom-1, top-1, -1):
                res.append(matrix[i][left])
            
            left += 1
        
        return res