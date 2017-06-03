import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        String[] temp = new String[] {"hot","dot","dog","lot","log","cog"};
        String[] temp2 = new String[] {"ted","tex","red","tax","tad","den","rex","pee"};
        String[] temp3 = new String[] {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
        String[] temp4 = new String[] {"kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"};
        List<String> wordList = Arrays.asList(temp4);
        //int res = answer.ladderLength("hit", "cog",  wordList);
        //List<List<String>> res = answer.findLadders("hit", "cog",  wordList);
        //List<List<String>> res = answer.findLadders("red", "tax",  wordList);
        List<List<String>> res = answer.findLadders("cet", "ism",  wordList);
        
        System.out.println(res);       
	}
	
	//127
	//Ë«ÏòBFS, this is other's code
	//	It's much faster than one-end search indeed as explained in wiki.
	//	BFS isn't equivalent to Queue. Sometimes Set is more accurate representation for nodes of level. (also handy since we need to check if we meet from two ends)
	//	It's safe to share a visited set for both ends since if they meet same string it terminates early. (vis is useful since we cannot remove word from dict due to bidirectional search)
	//	It seems like if(set.add()) is a little slower than if(!contains()) then add() but it's more concise.
	
	//http://blog.csdn.net/jollyjumper/article/details/5378993
	//http://www.voidcn.com/blog/ww32zz/article/p-5040214.html
	
	//This one is clear: http://www.cppblog.com/Yuan/archive/2011/02/23/140553.aspx
	
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList), qstart = new HashSet<>(), qend = new HashSet<>(), visited = new HashSet<>();
        
        qstart.add(beginWord);
        
     	// all transformed words must be in dict (including endWord)
        if (dict.contains(endWord))
        	qend.add(endWord); 
        
        
        for (int len = 2; !qstart.isEmpty(); len++) {
            // switch to small one to traverse from other end
            if(qstart.size()>qend.size()){
            	Set<String> temp = qstart;
            	qstart = qend;
            	qend=temp;
            }        	
        	
            Set<String> nq = new HashSet<>();
            
            for (String word : qstart) {
            	
                for (int j = 0; j < word.length(); j++) {
                    char[] ch = word.toCharArray();
                    
                    for (char c = 'a'; c <= 'z'; c++) {
                    	// beginWord and endWord not the same, so bypass itself
                        if (c == word.charAt(j)) 
                        	continue; 
                        
                        ch[j] = c;
                        String trans = String.valueOf(ch);
                        
                        // meet from two ends
                        if (qend.contains(trans))
                        	return len; 
                        
                        // not meet yet, visited is safe to use
                        if (dict.contains(trans) && !visited.contains(trans)) {
                        	visited.add(trans);
                        	nq.add(trans); 
                        }
                        	
                    }
                }
            }
            qstart = nq;
        }
        return 0;
    }
    
	//127
	//BFS
    public int ladderLength_withHelper(String beginWord, String endWord, List<String> wordList) {
    	Queue<String> q = new LinkedList<String>();
    	HashSet<String> visited = new HashSet<String>();
    	int jump=1;
    	
    	q.add(beginWord);
    		
    	while(!q.isEmpty()){
    		int levelItemCount = q.size();
    		jump++;
    		for(int i=0; i<levelItemCount; i++){
        		String cur = q.poll();
        		        		
        		for(int j=0; j<wordList.size(); j++){
        			String trans = wordList.get(j);
        			
        			if(visited.contains(trans) || !canTransfer(cur, trans))
        				continue;
        			
            		if(trans == endWord)
            			return jump;        			
        			
        			q.add(trans);
        			visited.add(trans);
        		}			
    		}
    	}
    	
    	return 0;
    }	
	
	//127
	//DFS, which is not suitable for this question
    public int ladderLength_dfs(String beginWord, String endWord, List<String> wordList) {
    	List<String> path = new ArrayList<String>();
    	path.add(beginWord);
    	return backtrack(endWord, wordList, path);
    }
    
    private int backtrack(String end, List<String> wordList, List<String> path){
    	String cur = path.get(path.size()-1);
    	if(cur.equals(end))
    		return path.size();
    	else if(path.size()-1 == wordList.size())
    		return 0;
    	
    	int minJump = 0;
    	for(int i=0; i<wordList.size(); i++){
    		String trans = wordList.get(i);
    		
    		if(path.contains(trans) || !canTransfer(cur, trans))
    			continue;
    		
    		path.add(trans);
    		int newlen = backtrack(end, wordList, path);
    		minJump = minJump==0 || (newlen>0 && newlen < minJump) ? newlen : minJump;
    		path.remove(path.size()-1);
    	}
    	
    	return minJump;
    }
    
    
    private boolean canTransfer(String word1, String word2){
    	int difCount =0;
    	for(int i=0; i<word1.length(); i++){
    		if(word1.charAt(i)!=word2.charAt(i))
    			difCount++;
    	}
    	
    	return difCount ==1;
    }
    
    //128
    //use Ë«ÏòBFS
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    	List<List<String>> res = new ArrayList<List<String>>();  
    	
    	Set<String> dict = new HashSet<>(wordList), visited = new HashSet<>();
    	//Since same current path end point can have multiple paths to get there with same length, we need to use a list of path to save all of them.
    	Map<String, List<List<String>>> qstart = new HashMap<>(), qend = new HashMap<>();
 	
    	List<String> startPath = new LinkedList<String>();
    	startPath.add(beginWord);
    	List<List<String>> sList = new LinkedList<List<String>>();
    	sList.add(startPath);
        qstart.put(beginWord, sList);
        
     	// all transformed words must be in dict (including endWord)
        if (dict.contains(endWord)){
        	List<String> endPath = new LinkedList<String>();
        	endPath.add(endWord);
        	List<List<String>> eList = new LinkedList<List<String>>();
        	eList.add(endPath);        	     	
        	qend.put(endWord, eList); 
        }   	
        else
        	return res;

        boolean inStartDire = true, foundRes = false;
        while(!qstart.isEmpty()){
            if(qstart.size()>qend.size()){
            	Map<String, List<List<String>>> temp = qstart;
            	qstart = qend;
            	qend = temp;
            	inStartDire=!inStartDire;
            }

            Map<String,List<List<String>>> temp = new HashMap<>();
            for(Map.Entry<String, List<List<String>>> cur: qstart.entrySet()){
            	String curWord = cur.getKey();
            	List<List<String>> curPathList = cur.getValue();
            	visited.add(curWord);
            	
            	if(qend.containsKey(curWord)){
            		foundRes = true;
            		for(List<String> curPath: curPathList){
                		if(inStartDire){
                			curPath.remove(curPath.size()-1);
                			for(List<String> endpath: qend.get(curWord)){
                				List<String> tempcurPath = new LinkedList<>(curPath);
                				tempcurPath.addAll(endpath);
                				res.add(tempcurPath);
                			}                			
                		}
                		else{
                			curPath.remove(0);
                			for(List<String> endpath: qend.get(curWord)){
                				List<String> tempcurPath = new LinkedList<>(curPath);
                				tempcurPath.addAll(0, endpath);
                				res.add(tempcurPath);
                			}
                		}
            		}
            		continue;
            	}
            	//if found res, avoid to go to find next level, just iterate through to generate all res
            	else if(foundRes)
            		continue;
            	
            	for(int i=0; i<curWord.length(); i++){
            		char[] curCh = curWord.toCharArray();
            		for(char ch ='a'; ch<='z'; ch++){
            			curCh[i]=ch;
            			String trans = String.valueOf(curCh);
            			
            			if(trans.equals(cur))
            				continue;
            			
            			if(dict.contains(trans) && !visited.contains(trans) ){
            				List<List<String>> newPathList = new LinkedList<>();
            				for(List<String> curPath: curPathList){
            					List<String> newPath = new LinkedList<>(curPath);
                				if(inStartDire)
                					newPath.add(trans);
                				else
                					newPath.add(0,trans);
                				newPathList.add(newPath);
            				}
            				if(temp.containsKey(trans)){
                				List<List<String>> curTransPathList = temp.get(trans);
                				newPathList.addAll(curTransPathList);
            				}

            				temp.put(trans,newPathList);

            			}
            				
            		}
            	}	
            }
            
            //Found the res, clear qstart to stop the loop
            qstart = foundRes? new HashMap<String,List<List<String>>>() : temp;
        }
        
        return res;
    }
}
