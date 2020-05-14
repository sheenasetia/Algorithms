//considering word length is always greater than or equal to 1
public class Trie{

    class TrieNode {
        TrieNode children[];
        boolean isEnd;
        
        TrieNode() {
            children = new TrieNode[26];
        }
        
        boolean hasChild(char ch)   //if that particular node is present
        {
            return children[ch-'a']!=null;
        }
        
        TrieNode getNode(char ch)
        {
            return children[ch-'a'];
        }
        
        void createChild(char ch)
        {
            children[ch-'a']=new TrieNode();
        }
        
        void setEnd()
        {
            isEnd=true;
        }
        
        boolean isEndTrue()
        {
            return isEnd;
        }
        
        boolean hasChildren()   // if any child node found which is not null
        {
            for(int i=0;i<26;i++)
            {
                if(children[i]!=null)
                return true;
            }
            return false;
        }
        
    }
    
    private TrieNode root=new TrieNode();
    
    void insert(String word)
    {
        TrieNode node=root;
        for(int i=0;i<word.length();i++)
        {
            if(node.hasChild(word.charAt(i))==false)
            {
                node.createChild(word.charAt(i));
            }
            node = node.getNode(word.charAt(i));
        }
        
        node.setEnd();
    }
    
    TrieNode searchPrefix(String prefix)    //helper method for search and prefix method
    {
        TrieNode node = root;
        for(int i=0;i<prefix.length();i++)
        {
            if(node.hasChild(prefix.charAt(i)))
            {
                node = node.getNode(prefix.charAt(i));
            }
            else
            {
                return null;
            }
        }
        return node;
    }
    
    
    boolean search(String word)     //search for full word
    {
        TrieNode t = searchPrefix(word);
        return (t!=null && t.isEndTrue());
    }
    
    boolean startsWith(String word)     //all prefixes
    {
        TrieNode t = searchPrefix(word);
        return (t!=null);
    }
    
    boolean delete(String word) //returns true if word present and deleted
    {
        TrieNode t = searchPrefix(word);    
        if((t!=null && t.isEndTrue())==false)   //word not present
        return false;
        
        deleteUtil(root,word,0);
        return true;
    }
    
    boolean deleteUtil(TrieNode t,String word,int i)
    {
        if(i==word.length())
        {
            if(t.hasChildren()==false)
            {
                return true;
            }
            else
            {
                t.isEnd=false;
                return false;
            }
        }
        
        TrieNode node = t.getNode(word.charAt(i));
        boolean b=deleteUtil(node,word,i+1);
        if(b==true)
        {
            t.children[word.charAt(i)-'a']=null;
            if(t.hasChildren()==false && t.isEnd==false)
            return true;
            
            return false;
        }
        else
        {
            return false;
        }
    }
    
     public static void main(String []args){
        
        Trie t=new Trie();
        String keys[] = { "the", "a", "there", 
                      "answer", "any", "by", 
                      "bye", "their", "hero", "heroplane" };
        
        for(int i=0;i<keys.length;i++)
        {
            t.insert(keys[i]);
        }
        
        System.out.println(t.search("the"));
        System.out.println(t.search("these"));
        System.out.println(t.delete("heroplane"));
        System.out.println(t.search("hero"));
     }
}
