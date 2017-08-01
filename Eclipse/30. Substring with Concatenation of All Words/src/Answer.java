
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;


public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        List<Integer> res = answer.findSubstring("wordgoodgoodgoodbestword", new String[] {"word","good","best","good"});
        List<Integer> res2 = answer.findSubstring("aaaaaaaa", new String[] {"aa","aa","aa"});
        List<Integer> res3 = answer.findSubstring("ttqupktjvqeeylzkyirjnnjuhyrmrhwkaoepyzavshbquaasltdyimtpmmddtzotnsknsnkkumcooeizxmyfyrwlfbqyaetpzdetsodmahcpllqizopzhnmmodkqhdfijjbbxgqansryfhiewzgfmsscvcsfizntkpukvkkjfbjmkutitzoirgmpkfuughnrykbuwnfbqqqckjlgizqbhcqtjkosudlunookbvntodvymggwhyaodqkodygzbrtpfkbifodtszughcdpdffgvpwapdzrwtiefjomxsirrcyygdpjixrfmogctfvpafvfqksncchtgftmklysipxudfyynvoncjvsvpixrpsxumlexjyfbxbgdcfqzvfcgcuctczmtsjngxtdgtkjrnqwrxorsvvyaratwcgpurfaoyfxurgneylyvzrpwmowdqqzsyropwqewvbqojfvkqtfrkxowlmbdcdycumssdwoazhpkmkufdcwpzmnmzopdtngpcyhfwyfxhuhvecajexyfjlrkcioxywnauwfsumpbhwxnazzgwzlincurnioleblaysssejwngvdgucntdadqdxhqgwdmxonxghsmrqazldhfhuakvdbabksjgvvglkdtuxhlnhkymtgtogglmhnnrhwaetgrelkyjrlwbxxnqfjgnptzygmrpkrtezkklwiwqvursrgkyrrmgklgtaykmpgqpsacpkyhfsazmgkkadygnmnioltaczrtrtvigvpnqrncazoacpirbvapivpnwigpeeykzpxphmtjlkjnzrhaphrxeimartpxxphyheoqtjzetiuszbuokloowaqnvhkuzttgzjwssxxmftggubxeoluknkzjtldsgyygjwyctxqaqwhmzeqqrmcewepsrvkyvjgfhehbezbwxkjxqbphoromxfepappwavdhzkkflociynhpowycqmrnsveumtsmovwqhgxsuzdvmkkdjihzxyoruvlioevfbtvjzsdwugritblcltdkrtbnonydtvkwofhnzljvtceodrqrktbendtdstinosjczrsbedwzgcolugcgagmpliudbdqqvbuxumyyquawxqhtwmzwsondwiizlapibmfyyfyoaymzouulivjajzfhhnhunyeqkmojrnztnmuciopqkyqtxxbgkkczihrttiemxdgkpaoxpdnzefudcxkohmpsvjlqrpdoujykjpjaszbygycjvozfarxyakorbrhvchhowtorsqpyotjlhlskcricbwveqecsllgiexbwpsxfmgqttldvcnzgmwkcaowmafwecxdrpcwdkoxezczeqbkexwiyleknlgtnfwgwaealtzpuboytrkxphfnumxhxfanmztizykktjbpnsqgjagyhnldzkkzpnmdohmpfwcaidqvvidhilfszrvadibvxnynvkccjgftmxqhftqnhwfgpdislmnkzmxwybbjigcudsdkouxvqfdhinzvzphbdezdfanpirjnmnxcjxxbccimpjjraqsdwrhbuwtencsbrrdaocdqenewxnpzfhdbamfwkybxatbumewbjatnnylmlamrjrumfzkpxloagputwqufsnuiliwzkkswbmiimszlgolmfhhdabisrfcenzfzjxvnmfxayxlgnzssgayidibwnfbceicqizfufcwfzjlmidhrffzlpchdikhotlgbllxsotxncicnnletsdehinmsyugthnuuyrmomjeoridfthannguvvhntdvomkkhjbtzpfdgyljfgrftgnqbjzqecltqwdxhhtgwymcyzoegfjblxrogqekurflpjkwqdfodttcuhgamrezqxpyovlkoqvezgcrljgpcztxizzwsfvjdmhthsdvlbbmjeeunmjsnervdsryyohbaqwjlzgwaiijmogbcrtpwmmbffzdtggvzcgkbngexqplfvmhpizlulmztmeoukmtmsdohlugclrjhgsyorjkfvmajqogbazntfdcsxjwlcfuiasytbjayvaklpqmprckwfppfynqctklvcjofupfpppbgfpwzrivzxmexawavglqkwgprxwgnmjttbrssaqrxexvetvbbitleacvxzcmnnigozbjzrazvauctrdxzzkdbnzyodndqvjhwmqydsxbstdokilljvqkkrjauydntpwpbmnhemixfnnrxyehtvrgmcgjamyvbulegalkpvjwiwqiwupsrgyglgplsphtjuarwldnhnkrlcziwqcqzawkinvbcewnawezkhmtwwkkamuxcwpbylngylhcpgpsevrocfhbeuleghbkdsobdbjdmrhezwydtrswwbzavkfdriqwbezehikwbrcaqagjrahnbgozsvelduheaglipveqogteizobzxoceebwbgifcrjdyunprrhgzamjzckaaadehgciomnrgzwevjvnccvbdhkekufkwkqdqumhhzynawtwfojhsgkxnucxqjhotzsluesdfsqgolcvbncttmriivgagppbphmjnhmsbeyqrclsrqnkcgvnbbnhqeihlxsygethktxbwlvnbjafpvstyicqmnyykqyqxrxhlxljigylpaqhxlavtemfrkfbcgtzzthmqsvaywlqwdxuozpjddrvpwysesrelasduqdvmqlivkemjwvozmjrlijrcavpdquxgxsspdckphyyfungiyxvignkjkboavlgugalldybmwzrsozbnxyvfniqyleahsjdyjpjmnkyjmrcarfpqfnxtvotgutpmetmoiwcxidgwwkxnpofvbdqwtjfnewcjpozzmbwxgftdpsshhaciduhwdmljinuaetbqxanffjiubddidfrgbyeemrqwfkyjeabdcrihatdbwhmzodhqdnwpemljzmudmyiqpqxpjcsflegajnsmaqdhfrsednjrlrhchgttinaushwdwqszgvgnmyrrnaiyrrcbxvwgjwcdfagcqybywjmkhfcvgkvzcacbvyjgxljcnsefqheoqszaxbvfnshrsjtqkcwhqgjdaqjsxphojgoihlowfxoyihqslmbbunhudqnahuqqcgylrohxlxxweposbstyfasishkbdbrfhsqbiaauxzqeogwrarpfuipmpaovdhambtnkvpguoyyeewwhqlmkvcyneoihyivzdjjyarvppttwsrdidpuytslzhtiheegjpskpjfgzacxstacwrwxnrkmagvhkzpvohffrkmslopfhpigigfvzpibvdiheadshixavlsgzhljyvrhewcflmhhprotrtnzcnbxyufadsjcqalwynbjaksrcjnvccwgrydssksvddztfkrdasocdhthqiculzbezgwrroowtoraaifaaucfdymvirpvsqarzwiqnymiodjpnorniwvnuhieayasqajpythnstwgyfxnvpdglythhclicnaspmkofrbxnxgnefbaueghcbqldetfrwahikxnbanqyveeafgxloepqxatbwbssbbcnapobehzzlfcsmzdadsqaumdqnykozmbaerbiackljmfvnkyseotzcyrpwcfyoiyscbdcfpqodxmqikioadndchsyjawziwsmzxpemhvrehhmrpdrtsuxzpxiruizscmubdapkvgoendvegpzylwacuitqstkwhexmfmwcumhjpeoxtnyfmyjgidwdygzfnzrunpwibfrtkhsfvqkjowpzzncxvbeiaxcombypgriszdywtkfkgujfjnceqgnrfrhruhjbyttxwrtqcaciunqdaskqbxjgqsalzjoyehxbbttftvpqifviafadeklxclicwwcbfbeiuxpquficmdmolmtryfobswfrujsckykhvaxphftvkfkvtdnskbvdaauujowvmjcjlzasgtnrazmvfbnrfkufkqbvgarsjtduvdobyduyfhumkjdpuawgqycxavrjqxflavpzyjzdsvpffvubvrhlrjkrgecxbjkdebcenekfzbmgwhhrapdtanmhrqguzqyfuclhgvoixbotkylmpqfrftyzjgtkzrrtwcacaqmxrdsbbfnsxujdnkeyqziptzkpemtedgdulxyofngciphxznwqnghiisxoessjaxelwczdrfgzvpzufxmsdwclozzurtesskdrofufkchhuiezfqtimvwcuxzntfhlrnefszmebvmvdsuiiprxkpbemcufhbtaozfiyuncpbxttubdjuawlecygwfqaaqqayzasmchpcciygljcofosioagvqgyjxyhwabkdkzhnjfvuqxiwlcgzdmvvvtgutpstqcybdfqomliditbuvhvavqyslemeueamiapngfbuskzbfaxcjudhldzyjmfdqfsbfhonpqihchkhkjjteoarrapbouggbahhiwuzoegsotzycktizwzswrvmlesneawoysnozwgnpfntrgescdnawimiohxvhtlhnzvmxdzokohbxnubrhcnrqxizwdiropfpmrmptazhkdexxiqgkgzcfjccmmtdcysqshgljhutkbtjjjrvrtzxcdbpquuuvmknvsafawymztykfphwihvnmwectywomjdibfnddnsfhqpohxkseifqgjvzhtpvcudgbslhgdmptbdbyptezaxgjshsnxnqtryvjjcrnoiirnlqdewcgvkppshdpvvkotfzcjrrzbarpljushwydjosbxvsuqcijkiovbfvcfottznlgmljvbcwzxqvouezeopcpvxtcnnvmaisoucjvehwdxstsyvymkadfzwiolfaoovcixofdvcivwcpuxpghqjprhzgteihsdlcczifvmosisjerymaqvpieoqxtygncsqeramomcgwupanqmngjfontgnoftejlunfuzvidceztgmlucsfhiscphrwbvforsvnurvzvzzohlabnugucaztiqpjnuzgpvtlmokhpjxwvzxkvfhyfgrnyjyndatsvodjcqstzrpwtohotqmaygqwpoluqgnluswyiqtkiigbwpprhetfmjddaqxqwmeshasrrlbbvietzvkhbeonpsqpioghckzjmubfhcgdmmwoijxjplxedpuofavimwtasugazodnbbblkyuzktepjafqccyqbsqtoyvnnadqcebmfvorruiawoqyqrotlgnbfirujuknynbfkrwblhdhvuhnnxhaewbjgsdrmpencismzrqlytuvnekcbtcfreqywtrjiwymeqbfjrqhknearpcukfaclsahmrswpqlvjmbsdtcnigpzxsukzwmkootchmbxeounavgfrkuzqkbqexadvmnlciojurgbfdohaworgirzsupwrrbmfqxhznqvgzwncnucjiuqtnpnhgmyxnmcejjdzbafaxtckpftazltocgvisvhihjmsurrwrxwqqzahgwhhjcvmlswdnelwnzokqggkdeavfdelbmsmopabhxfwbssquhcmpkwupzpuetihhctysuzzrgwubqmvxpjoziiohxlntvucxpcpjcrckpynflifautbccqjbdywasbxhdpthixuxwhehqljkfkojcxmhvlhpmhwryrzgptflajusvfecpsnurbdomldaucsstrykmdvmorhlwnpogcizelosyrtuvlmrembqrxeiqntnbjbjnlitywmxqhrlugeyugqmfwuvkpinylwowghvdvuveniyvnyqtocylytxnekopicoolltjfonuzmqmkghbkhoialvgxlyhpmvdxpmefzyenosawzbggrojcmrbzpipddscueicfhivxbvwcyclprutfnuedevijnngtvibeqwcttyytcjivfdaszhxdcimqvsjqakvtizobxmubxexchxvgeulhcyzxqkotxjofkejjrfkokhttfoclknunntkggazdlpkvttemzpdlwwgdmirwyljlhwrpwssihcddykrzzukxssdgbwdbjomqmghjyztiewnciedhbphvhmckihlrxykkgrvetooxmbbvieejtleaxinhryzpylzecwlvkzuwdvrlbwuwjaxjlmqckrrjcspfoacaaxxduqqwmksymrhxdzcortztooaepffrccwwsmuhynfkgokknmaghbcvpcagjfzljvkdjgkhvrucfgovsqbbrdxii", new String[] {"wxnazzgwzlincurnioleblays","txwrtqcaciunqdaskqbxjgqsa","vdhzkkflociynhpowycqmrnsv","sondwiizlapibmfyyfyoaymzo","advmnlciojurgbfdohaworgir","gbwpprhetfmjddaqxqwmeshas","vmjcjlzasgtnrazmvfbnrfkuf","zjxvnmfxayxlgnzssgayidibw","xmsdwclozzurtesskdrofufkc","gglmhnnrhwaetgrelkyjrlwbx","galldybmwzrsozbnxyvfniqyl","ofrbxnxgnefbaueghcbqldetf","ltaczrtrtvigvpnqrncazoacp","psacpkyhfsazmgkkadygnmnio","mztmeoukmtmsdohlugclrjhgs","gjdaqjsxphojgoihlowfxoyih","gpcztxizzwsfvjdmhthsdvlbb","bksjgvvglkdtuxhlnhkymtgto","mewbjatnnylmlamrjrumfzkpx","orsqpyotjlhlskcricbwveqec","wsrdidpuytslzhtiheegjpskp","zehikwbrcaqagjrahnbgozsve","lzjoyehxbbttftvpqifviafad","phyyfungiyxvignkjkboavlgu","zdadsqaumdqnykozmbaerbiac","zxyoruvlioevfbtvjzsdwugri","xtvotgutpmetmoiwcxidgwwkx","cpvxtcnnvmaisoucjvehwdxst","jfgzacxstacwrwxnrkmagvhkz","nubrhcnrqxizwdiropfpmrmpt","rwahikxnbanqyveeafgxloepq","zncxvbeiaxcombypgriszdywt","ottznlgmljvbcwzxqvouezeop","rqguzqyfuclhgvoixbotkylmp","zdsvpffvubvrhlrjkrgecxbjk","kqbvgarsjtduvdobyduyfhumk","azhkdexxiqgkgzcfjccmmtdcy","igcudsdkouxvqfdhinzvzphbd","igylpaqhxlavtemfrkfbcgtzz","ezdfanpirjnmnxcjxxbccimpj","hwydjosbxvsuqcijkiovbfvcf","lzgwaiijmogbcrtpwmmbffzdt","fsqgolcvbncttmriivgagppbp","hsqbiaauxzqeogwrarpfuipmp","mxonxghsmrqazldhfhuakvdba","legajnsmaqdhfrsednjrlrhch","eebwbgifcrjdyunprrhgzamjz","suxzpxiruizscmubdapkvgoen","uvnekcbtcfreqywtrjiwymeqb","pquuuvmknvsafawymztykfphw","bhxfwbssquhcmpkwupzpuetih","pshdpvvkotfzcjrrzbarpljus","edgdulxyofngciphxznwqnghi","pwzrivzxmexawavglqkwgprxw","wimiohxvhtlhnzvmxdzokohbx","sjcqalwynbjaksrcjnvccwgry","qwfkyjeabdcrihatdbwhmzodh","thmqsvaywlqwdxuozpjddrvpw","jdpuawgqycxavrjqxflavpzyj","xphftvkfkvtdnskbvdaauujow","mwkcaowmafwecxdrpcwdkoxez","rrlbbvietzvkhbeonpsqpiogh","gyglgplsphtjuarwldnhnkrlc","sqshgljhutkbtjjjrvrtzxcdb","ihvnmwectywomjdibfnddnsfh","dymvirpvsqarzwiqnymiodjpn","evrocfhbeuleghbkdsobdbjdm","sbbfnsxujdnkeyqziptzkpemt","gmlucsfhiscphrwbvforsvnur","nfbceicqizfufcwfzjlmidhrf","tbqxanffjiubddidfrgbyeemr","fszmebvmvdsuiiprxkpbemcuf","ziwqcqzawkinvbcewnawezkhm","dmolmtryfobswfrujsckykhva","ewcflmhhprotrtnzcnbxyufad","qcebmfvorruiawoqyqrotlgnb","qdnwpemljzmudmyiqpqxpjcsf","xhaewbjgsdrmpencismzrqlyt","iyrrcbxvwgjwcdfagcqybywjm","rhezwydtrswwbzavkfdriqwbe","kljmfvnkyseotzcyrpwcfyoiy","xtygncsqeramomcgwupanqmng","uzoegsotzycktizwzswrvmles","fzlpchdikhotlgbllxsotxnci","rrwrxwqqzahgwhhjcvmlswdne","xtckpftazltocgvisvhihjmsu","aovdhambtnkvpguoyyeewwhql","qenewxnpzfhdbamfwkybxatbu","wqvursrgkyrrmgklgtaykmpgq","ezbwxkjxqbphoromxfepappwa","mzeqqrmcewepsrvkyvjgfhehb","ulzbezgwrroowtoraaifaaucf","rdxzzkdbnzyodndqvjhwmqyds","qtryvjjcrnoiirnlqdewcgvkp","slemeueamiapngfbuskzbfaxc","ssejwngvdgucntdadqdxhqgwd","lhgdmptbdbyptezaxgjshsnxn","qheoqszaxbvfnshrsjtqkcwhq","twwkkamuxcwpbylngylhcpgps","fszrvadibvxnynvkccjgftmxq","hftqnhwfgpdislmnkzmxwybbj","iimszlgolmfhhdabisrfcenzf","mztizykktjbpnsqgjagyhnldz","eacvxzcmnnigozbjzrazvauct","hkhkjjteoarrapbouggbahhiw","uknkzjtldsgyygjwyctxqaqwh","lduheaglipveqogteizobzxoc","ggvzcgkbngexqplfvmhpizlul","omjeoridfthannguvvhntdvom","uulivjajzfhhnhunyeqkmojrn","npofvbdqwtjfnewcjpozzmbwx","altzpuboytrkxphfnumxhxfan","scbdcfpqodxmqikioadndchsy","jfontgnoftejlunfuzvidcezt","pvohffrkmslopfhpigigfvzpi","kkhjbtzpfdgyljfgrftgnqbjz","sllgiexbwpsxfmgqttldvcnzg","exyfjlrkcioxywnauwfsumpbh","hkuzttgzjwssxxmftggubxeol","gftdpsshhaciduhwdmljinuae","uzktepjafqccyqbsqtoyvnnad","fnzrunpwibfrtkhsfvqkjowpz","gpvtlmokhpjxwvzxkvfhyfgrn","hgamrezqxpyovlkoqvezgcrlj","qslmbbunhudqnahuqqcgylroh","otchmbxeounavgfrkuzqkbqex","lcczifvmosisjerymaqvpieoq","ljvtceodrqrktbendtdstinos","jlkjnzrhaphrxeimartpxxphy","judhldzyjmfdqfsbfhonpqihc","lxrogqekurflpjkwqdfodttcu","firujuknynbfkrwblhdhvuhnn","cnnletsdehinmsyugthnuuyrm","stqcybdfqomliditbuvhvavqy","ckzjmubfhcgdmmwoijxjplxed","ttiemxdgkpaoxpdnzefudcxko","jiuqtnpnhgmyxnmcejjdzbafa","eumtsmovwqhgxsuzdvmkkdjih","irbvapivpnwigpeeykzpxphmt","czeqbkexwiyleknlgtnfwgwae","eklxclicwwcbfbeiuxpquficm","xatbwbssbbcnapobehzzlfcsm","ztnmuciopqkyqtxxbgkkczihr","heoqtjzetiuszbuokloowaqnv","vbdhkekufkwkqdqumhhzynawt","fjrqhknearpcukfaclsahmrsw","xlxxweposbstyfasishkbdbrf","qfrftyzjgtkzrrtwcacaqmxrd","ljcofosioagvqgyjxyhwabkdk","ecygwfqaaqqayzasmchpcciyg","lwnzokqggkdeavfdelbmsmopa","vzvzzohlabnugucaztiqpjnuz","hmpsvjlqrpdoujykjpjaszbyg","qecltqwdxhhtgwymcyzoegfjb","kkzpnmdohmpfwcaidqvvidhil","yorjkfvmajqogbazntfdcsxjw","ozmjrlijrcavpdquxgxsspdck","pbmnhemixfnnrxyehtvrgmcgj","hmjnhmsbeyqrclsrqnkcgvnbb","gnmjttbrssaqrxexvetvbbitl","mjeeunmjsnervdsryyohbaqwj","dbdqqvbuxumyyquawxqhtwmzw","pqlvjmbsdtcnigpzxsukzwmko","khfcvgkvzcacbvyjgxljcnsef","gttinaushwdwqszgvgnmyrrna","jawziwsmzxpemhvrehhmrpdrt","jraqsdwrhbuwtencsbrrdaocd","wcumhjpeoxtnyfmyjgidwdygz","zsupwrrbmfqxhznqvgzwncnuc","isxoessjaxelwczdrfgzvpzuf","mkvcyneoihyivzdjjyarvpptt","tblcltdkrtbnonydtvkwofhnz","bvdiheadshixavlsgzhljyvrh","wgyfxnvpdglythhclicnaspmk","jczrsbedwzgcolugcgagmpliu","hbtaozfiyuncpbxttubdjuawl","ysesrelasduqdvmqlivkemjwv","dvegpzylwacuitqstkwhexmfm","qpohxkseifqgjvzhtpvcudgbs","xnqfjgnptzygmrpkrtezkklwi","loagputwqufsnuiliwzkkswbm","qmaygqwpoluqgnluswyiqtkii","kfkgujfjnceqgnrfrhruhjbyt","hhuiezfqtimvwcuxzntfhlrne","fppfynqctklvcjofupfpppbgf","zhnjfvuqxiwlcgzdmvvvtgutp","wfojhsgkxnucxqjhotzsluesd","debcenekfzbmgwhhrapdtanmh","yjyndatsvodjcqstzrpwtohot","eahsjdyjpjmnkyjmrcarfpqfn","neawoysnozwgnpfntrgescdna","amyvbulegalkpvjwiwqiwupsr","orniwvnuhieayasqajpythnst","ckaaadehgciomnrgzwevjvncc","syvymkadfzwiolfaoovcixofd","dssksvddztfkrdasocdhthqic","vcivwcpuxpghqjprhzgteihsd","lcfuiasytbjayvaklpqmprckw","ycjvozfarxyakorbrhvchhowt","fpvstyicqmnyykqyqxrxhlxlj","puofavimwtasugazodnbbblky","nhqeihlxsygethktxbwlvnbja","xbstdokilljvqkkrjauydntpw"});
       
        System.out.println(res3);
	}
	
    public List<Integer> findSubstring(String s, String[] words) {
        int start=0, end=0;
        HashMap<String, Integer> dic = new HashMap<>();
    }
	
    
	//Time Limit Exceeded
    public ArrayList<Integer> findSubstring_TL(String s, String[] words) {
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	if(words.length <=0)
    		return res;
    	
    	int wordLen = words[0].length();
    	ArrayList<String> wordsSet = new ArrayList<String>();
    	for(int i=0; i<words.length; i++){
    		wordsSet.add(words[i]);
    	}
    	
    	//<starting point, exsitedList>
    	HashMap<Integer, ArrayList<String>> noneExsitedList = new HashMap<Integer, ArrayList<String>>();
    	
    	
    	for(int i=0; i<s.length()-wordLen+1; i++){
    		String curSub = s.substring(i, i+wordLen);
    		HashMap<Integer, ArrayList<String>> updateNoneExsitedList = new HashMap<Integer, ArrayList<String>>();
    		
    		if(wordsSet.contains(curSub)){	
    			//mark current position as a new starting point
    			ArrayList<String> newList = new ArrayList<String>(wordsSet);
    			newList.remove(curSub);
    			noneExsitedList.put(i, newList);	
    			
    			for(Entry<Integer, ArrayList<String>> item : noneExsitedList.entrySet()){

    				ArrayList<String> noneExsited = item.getValue();
    				int curIndex = item.getKey();
    				
    				//the new added starting point or starting point not belong this iterate
        			if(curIndex == i || (i-curIndex)%wordLen !=0){
        				updateNoneExsitedList.put(curIndex, noneExsited);
        			}
        			//previous added starting point
        			else if((i-curIndex)%wordLen ==0 && noneExsited.contains(curSub)){            			
        				noneExsited.remove(curSub);
        				updateNoneExsitedList.put(curIndex, noneExsited);
        			}
        			//
        			if(noneExsited.isEmpty()){
        				res.add(curIndex);
        				updateNoneExsitedList.remove(curIndex);
        			}          			
    			}
    			noneExsitedList=updateNoneExsitedList;
    			//i+=wordLen;    
    		}  
    		else{
    			for(Entry<Integer, ArrayList<String>> item : noneExsitedList.entrySet()){
    				ArrayList<String> noneExsited = item.getValue();
    				int curIndex = item.getKey();
    				
    				if((i-curIndex)%wordLen !=0){
    					updateNoneExsitedList.put(curIndex, noneExsited);
    				}
    			}
    			noneExsitedList=updateNoneExsitedList;
    		}
    	}
    	return res;
    }	
	
}
