class Solution {
    /**
     * @param {string[]} strs
     * @return {string[][]}
     */
    groupAnagrams(strs) {

        const map = new Map();

        for (let str of strs) {
            const count = new Array(26).fill(0);

            for (let i = 0; i < count.length; i++) {
                count[str.charCodeAt(i) - 'a'.charCodeAt(0)]++;
            }

            const key = count.join(',');
            if (!map[key]) {
                map[key] = [];
            }
            map[key].push(str);
        }

        return Object.values(map);
    }
}
