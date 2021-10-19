package com.jysun.practice.medium;

/**
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 *
 * 实现词典类 WordDictionary ：
 *
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 *
 *
 * 示例：
 *
 * 输入：
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * 输出：
 * [null,null,null,null,false,true,true,true]
 *
 * 解释：
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 *
 *
 * 提示：
 * 1 <= word.length <= 500
 * addWord 中的 word 由小写英文字母组成
 * search 中的 word 由 '.' 或小写英文字母组成
 * 最多调用 50000 次 addWord 和 search
 * @author json
 * @since 2021/10/19
 */
public class Medium211 {

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("bdd");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True
    }

    static class WordDictionary {

        private Trie root;

        public WordDictionary() {
            root = new Trie();
        }

        public void addWord(String word) {
            root.insert(word);
        }

        /**
         * 搜索思路：
         * 1、如果匹配到 . 则直接搜索剩下的元素即可
         * 2、如果匹配到字母，则判断当前Trie的children是否包含该字母 - 'a' 的下标节点
         *      如果存在该下标节点，搜索剩下元素即可
         *      如果不存在直接返回false
         *      当前下标节点为isEnd时，判断字母搜索下标是否走到了word.length - 1返回结果即可
         */
        public boolean search(String word) {
            return dfs(word, 0, root);
        }

        /**
         * 递归
         * 1、终止条件：index到达了word.length。返回isEnd
         * 2、返回值：返回当前index是否在node中有所匹配
         * 3、做什么：取当前节点判断是否存在
         */
        private boolean dfs(String word, int index, Trie node) {
            if (index == word.length()) {
                return node.isEnd;
            }
            char c = word.charAt(index);
            if (c == '.') {
                // 匹配任意字符，取node的每一个children递归处理
                for (int i = 0; i < 26; i++) {
                    Trie child = node.children[i];
                    if (child != null && dfs(word, index + 1, child)) {
                        return true;
                    }
                }
            } else {
                int idx = c - 'a';
                Trie child = node.children[idx];
                return child != null && dfs(word, index + 1, child);
            }
            return false;
        }

        class Trie {
            private Trie[] children;
            private boolean isEnd;

            /**
             * 26个首字母
             */
            public Trie() {
                children = new Trie[26];
                isEnd = false;
            }

            public void insert(String word) {
                Trie node = this;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    // 如果一开始首字母没有就初始化一颗trie树
                    int idx = c - 'a';
                    if (node.children[idx] == null) {
                        node.children[idx] = new Trie();
                    }
                    node = node.children[idx];
                }
                node.isEnd = true;
            }

            public Trie[] getChildren() {
                return children;
            }

            public boolean isEnd() {
                return isEnd;
            }
        }
    }
}
