class Solution {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    TrieNode  root = new TrieNode();
    List<String> result = new ArrayList<>();
    
    public List<String> findWords(char[][] board, String[] words) {

        for(String word : words){
            insert(word);
        }

        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                dfs(board, r, c, root);
            }
        }

        return result;
    }

    private void insert(String word){

        TrieNode current = root;

        for(char c : word.toCharArray()){

            int index = c - 'a';

            if(current.children[index] == null){
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.word = word;
    }

    private void dfs(char[][] board, int row, int col, TrieNode node){
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length){
            return;
        }

        char ch = board[row][col];

        if(ch == '#'){
            return;
        }

        node = node.children[ch - 'a'];

        if(node == null){
            return;
        }

        if(node.word != null){
            result.add(node.word);
            node.word = null;
        }

        board[row][col] = '#';

        dfs(board, row + 1, col, node);
        dfs(board, row - 1, col, node);
        dfs(board, row, col + 1, node);
        dfs(board, row, col - 1, node);

        board[row][col] = ch;
    }
}
