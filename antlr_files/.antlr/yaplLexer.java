// Generated from /Users/alegomez/Documents/UVG/Cuarto Año/Segundo Semestre/Compis/Compis/antlr_files/yapl.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class yaplLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		WHITESPACE=18, BLOCK_COMMENT=19, LINE_COMMENT=20, CLASS=21, ELSE=22, FALSE=23, 
		FI=24, IF=25, IN=26, INHERITS=27, ISVOID=28, LET=29, LOOP=30, POOL=31, 
		THEN=32, WHILE=33, CASE=34, ESAC=35, NEW=36, OF=37, NOT=38, TRUE=39, STRING=40, 
		INT=41, TYPE=42, ID=43, ASSIGNMENT=44, IMPLY=45;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"WHITESPACE", "BLOCK_COMMENT", "LINE_COMMENT", "CLASS", "ELSE", "FALSE", 
			"FI", "IF", "IN", "INHERITS", "ISVOID", "LET", "LOOP", "POOL", "THEN", 
			"WHILE", "CASE", "ESAC", "NEW", "OF", "NOT", "TRUE", "STRING", "INT", 
			"TYPE", "ID", "ASSIGNMENT", "IMPLY", "A", "C", "D", "E", "F", "H", "I", 
			"L", "N", "O", "P", "R", "S", "T", "U", "V", "W", "ESC", "UNICODE", "HEX"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'{'", "'}'", "'('", "','", "')'", "':'", "'@'", "'.'", 
			"'~'", "'*'", "'/'", "'+'", "'-'", "'<='", "'<'", "'='", null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"'<-'", "'=>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "WHITESPACE", "BLOCK_COMMENT", "LINE_COMMENT", 
			"CLASS", "ELSE", "FALSE", "FI", "IF", "IN", "INHERITS", "ISVOID", "LET", 
			"LOOP", "POOL", "THEN", "WHILE", "CASE", "ESAC", "NEW", "OF", "NOT", 
			"TRUE", "STRING", "INT", "TYPE", "ID", "ASSIGNMENT", "IMPLY"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public yaplLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "yapl.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2/\u017a\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6"+
		"\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3"+
		"\17\3\17\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\6\23\u00aa\n\23\r\23"+
		"\16\23\u00ab\3\23\3\23\3\24\3\24\3\24\3\24\3\24\7\24\u00b5\n\24\f\24\16"+
		"\24\u00b8\13\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\7\25\u00c3"+
		"\n\25\f\25\16\25\u00c6\13\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3"+
		"\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3"+
		"\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3\"\3\""+
		"\3\"\3\"\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3%\3&\3&\3&\3\'\3\'\3"+
		"\'\3\'\3(\3(\3(\3(\3(\3)\3)\3)\7)\u012c\n)\f)\16)\u012f\13)\3)\3)\3*\6"+
		"*\u0134\n*\r*\16*\u0135\3+\3+\7+\u013a\n+\f+\16+\u013d\13+\3,\3,\7,\u0141"+
		"\n,\f,\16,\u0144\13,\3-\3-\3-\3.\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62"+
		"\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39\39\3"+
		":\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3@\5@\u0171\n@\3A\3A\3A\3A\3"+
		"A\3A\3B\3B\4\u00b6\u00c4\2C\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32"+
		"\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\2_\2a\2"+
		"c\2e\2g\2i\2k\2m\2o\2q\2s\2u\2w\2y\2{\2}\2\177\2\u0081\2\u0083\2\3\2\33"+
		"\5\2\13\f\16\17\"\"\4\2$$^^\3\2\62;\3\2C\\\6\2\62;C\\aac|\3\2c|\4\2CC"+
		"cc\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2JJjj\4\2KKkk\4\2NNnn\4\2PPpp\4\2"+
		"QQqq\4\2RRrr\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\n\2$$\61"+
		"\61^^ddhhppttvv\5\2\62;CHch\2\u016f\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2"+
		"\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3"+
		"\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2"+
		"\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2"+
		"\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2["+
		"\3\2\2\2\3\u0085\3\2\2\2\5\u0087\3\2\2\2\7\u0089\3\2\2\2\t\u008b\3\2\2"+
		"\2\13\u008d\3\2\2\2\r\u008f\3\2\2\2\17\u0091\3\2\2\2\21\u0093\3\2\2\2"+
		"\23\u0095\3\2\2\2\25\u0097\3\2\2\2\27\u0099\3\2\2\2\31\u009b\3\2\2\2\33"+
		"\u009d\3\2\2\2\35\u009f\3\2\2\2\37\u00a1\3\2\2\2!\u00a4\3\2\2\2#\u00a6"+
		"\3\2\2\2%\u00a9\3\2\2\2\'\u00af\3\2\2\2)\u00be\3\2\2\2+\u00cb\3\2\2\2"+
		"-\u00d1\3\2\2\2/\u00d6\3\2\2\2\61\u00dc\3\2\2\2\63\u00df\3\2\2\2\65\u00e2"+
		"\3\2\2\2\67\u00e5\3\2\2\29\u00ee\3\2\2\2;\u00f5\3\2\2\2=\u00f9\3\2\2\2"+
		"?\u00fe\3\2\2\2A\u0103\3\2\2\2C\u0108\3\2\2\2E\u010e\3\2\2\2G\u0113\3"+
		"\2\2\2I\u0118\3\2\2\2K\u011c\3\2\2\2M\u011f\3\2\2\2O\u0123\3\2\2\2Q\u0128"+
		"\3\2\2\2S\u0133\3\2\2\2U\u0137\3\2\2\2W\u013e\3\2\2\2Y\u0145\3\2\2\2["+
		"\u0148\3\2\2\2]\u014b\3\2\2\2_\u014d\3\2\2\2a\u014f\3\2\2\2c\u0151\3\2"+
		"\2\2e\u0153\3\2\2\2g\u0155\3\2\2\2i\u0157\3\2\2\2k\u0159\3\2\2\2m\u015b"+
		"\3\2\2\2o\u015d\3\2\2\2q\u015f\3\2\2\2s\u0161\3\2\2\2u\u0163\3\2\2\2w"+
		"\u0165\3\2\2\2y\u0167\3\2\2\2{\u0169\3\2\2\2}\u016b\3\2\2\2\177\u016d"+
		"\3\2\2\2\u0081\u0172\3\2\2\2\u0083\u0178\3\2\2\2\u0085\u0086\7=\2\2\u0086"+
		"\4\3\2\2\2\u0087\u0088\7}\2\2\u0088\6\3\2\2\2\u0089\u008a\7\177\2\2\u008a"+
		"\b\3\2\2\2\u008b\u008c\7*\2\2\u008c\n\3\2\2\2\u008d\u008e\7.\2\2\u008e"+
		"\f\3\2\2\2\u008f\u0090\7+\2\2\u0090\16\3\2\2\2\u0091\u0092\7<\2\2\u0092"+
		"\20\3\2\2\2\u0093\u0094\7B\2\2\u0094\22\3\2\2\2\u0095\u0096\7\60\2\2\u0096"+
		"\24\3\2\2\2\u0097\u0098\7\u0080\2\2\u0098\26\3\2\2\2\u0099\u009a\7,\2"+
		"\2\u009a\30\3\2\2\2\u009b\u009c\7\61\2\2\u009c\32\3\2\2\2\u009d\u009e"+
		"\7-\2\2\u009e\34\3\2\2\2\u009f\u00a0\7/\2\2\u00a0\36\3\2\2\2\u00a1\u00a2"+
		"\7>\2\2\u00a2\u00a3\7?\2\2\u00a3 \3\2\2\2\u00a4\u00a5\7>\2\2\u00a5\"\3"+
		"\2\2\2\u00a6\u00a7\7?\2\2\u00a7$\3\2\2\2\u00a8\u00aa\t\2\2\2\u00a9\u00a8"+
		"\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac"+
		"\u00ad\3\2\2\2\u00ad\u00ae\b\23\2\2\u00ae&\3\2\2\2\u00af\u00b0\7*\2\2"+
		"\u00b0\u00b1\7,\2\2\u00b1\u00b6\3\2\2\2\u00b2\u00b5\5\'\24\2\u00b3\u00b5"+
		"\13\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b3\3\2\2\2\u00b5\u00b8\3\2\2\2"+
		"\u00b6\u00b7\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7\u00b9\3\2\2\2\u00b8\u00b6"+
		"\3\2\2\2\u00b9\u00ba\7,\2\2\u00ba\u00bb\7+\2\2\u00bb\u00bc\3\2\2\2\u00bc"+
		"\u00bd\b\24\3\2\u00bd(\3\2\2\2\u00be\u00bf\7/\2\2\u00bf\u00c0\7/\2\2\u00c0"+
		"\u00c4\3\2\2\2\u00c1\u00c3\13\2\2\2\u00c2\u00c1\3\2\2\2\u00c3\u00c6\3"+
		"\2\2\2\u00c4\u00c5\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c5\u00c7\3\2\2\2\u00c6"+
		"\u00c4\3\2\2\2\u00c7\u00c8\7\f\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca\b\25"+
		"\3\2\u00ca*\3\2\2\2\u00cb\u00cc\5_\60\2\u00cc\u00cd\5k\66\2\u00cd\u00ce"+
		"\5]/\2\u00ce\u00cf\5u;\2\u00cf\u00d0\5u;\2\u00d0,\3\2\2\2\u00d1\u00d2"+
		"\5c\62\2\u00d2\u00d3\5k\66\2\u00d3\u00d4\5u;\2\u00d4\u00d5\5c\62\2\u00d5"+
		".\3\2\2\2\u00d6\u00d7\7h\2\2\u00d7\u00d8\5]/\2\u00d8\u00d9\5k\66\2\u00d9"+
		"\u00da\5u;\2\u00da\u00db\5c\62\2\u00db\60\3\2\2\2\u00dc\u00dd\5e\63\2"+
		"\u00dd\u00de\5i\65\2\u00de\62\3\2\2\2\u00df\u00e0\5i\65\2\u00e0\u00e1"+
		"\5e\63\2\u00e1\64\3\2\2\2\u00e2\u00e3\5i\65\2\u00e3\u00e4\5m\67\2\u00e4"+
		"\66\3\2\2\2\u00e5\u00e6\5i\65\2\u00e6\u00e7\5m\67\2\u00e7\u00e8\5g\64"+
		"\2\u00e8\u00e9\5c\62\2\u00e9\u00ea\5s:\2\u00ea\u00eb\5i\65\2\u00eb\u00ec"+
		"\5w<\2\u00ec\u00ed\5u;\2\u00ed8\3\2\2\2\u00ee\u00ef\5i\65\2\u00ef\u00f0"+
		"\5u;\2\u00f0\u00f1\5{>\2\u00f1\u00f2\5o8\2\u00f2\u00f3\5i\65\2\u00f3\u00f4"+
		"\5a\61\2\u00f4:\3\2\2\2\u00f5\u00f6\5k\66\2\u00f6\u00f7\5c\62\2\u00f7"+
		"\u00f8\5w<\2\u00f8<\3\2\2\2\u00f9\u00fa\5k\66\2\u00fa\u00fb\5o8\2\u00fb"+
		"\u00fc\5o8\2\u00fc\u00fd\5q9\2\u00fd>\3\2\2\2\u00fe\u00ff\5q9\2\u00ff"+
		"\u0100\5o8\2\u0100\u0101\5o8\2\u0101\u0102\5k\66\2\u0102@\3\2\2\2\u0103"+
		"\u0104\5w<\2\u0104\u0105\5g\64\2\u0105\u0106\5c\62\2\u0106\u0107\5m\67"+
		"\2\u0107B\3\2\2\2\u0108\u0109\5}?\2\u0109\u010a\5g\64\2\u010a\u010b\5"+
		"i\65\2\u010b\u010c\5k\66\2\u010c\u010d\5c\62\2\u010dD\3\2\2\2\u010e\u010f"+
		"\5_\60\2\u010f\u0110\5]/\2\u0110\u0111\5u;\2\u0111\u0112\5c\62\2\u0112"+
		"F\3\2\2\2\u0113\u0114\5c\62\2\u0114\u0115\5u;\2\u0115\u0116\5]/\2\u0116"+
		"\u0117\5_\60\2\u0117H\3\2\2\2\u0118\u0119\5m\67\2\u0119\u011a\5c\62\2"+
		"\u011a\u011b\5}?\2\u011bJ\3\2\2\2\u011c\u011d\5o8\2\u011d\u011e\5e\63"+
		"\2\u011eL\3\2\2\2\u011f\u0120\5m\67\2\u0120\u0121\5o8\2\u0121\u0122\5"+
		"w<\2\u0122N\3\2\2\2\u0123\u0124\7v\2\2\u0124\u0125\5s:\2\u0125\u0126\5"+
		"y=\2\u0126\u0127\5c\62\2\u0127P\3\2\2\2\u0128\u012d\7$\2\2\u0129\u012c"+
		"\5\177@\2\u012a\u012c\n\3\2\2\u012b\u0129\3\2\2\2\u012b\u012a\3\2\2\2"+
		"\u012c\u012f\3\2\2\2\u012d\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u0130"+
		"\3\2\2\2\u012f\u012d\3\2\2\2\u0130\u0131\7$\2\2\u0131R\3\2\2\2\u0132\u0134"+
		"\t\4\2\2\u0133\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0133\3\2\2\2\u0135"+
		"\u0136\3\2\2\2\u0136T\3\2\2\2\u0137\u013b\t\5\2\2\u0138\u013a\t\6\2\2"+
		"\u0139\u0138\3\2\2\2\u013a\u013d\3\2\2\2\u013b\u0139\3\2\2\2\u013b\u013c"+
		"\3\2\2\2\u013cV\3\2\2\2\u013d\u013b\3\2\2\2\u013e\u0142\t\7\2\2\u013f"+
		"\u0141\t\6\2\2\u0140\u013f\3\2\2\2\u0141\u0144\3\2\2\2\u0142\u0140\3\2"+
		"\2\2\u0142\u0143\3\2\2\2\u0143X\3\2\2\2\u0144\u0142\3\2\2\2\u0145\u0146"+
		"\7>\2\2\u0146\u0147\7/\2\2\u0147Z\3\2\2\2\u0148\u0149\7?\2\2\u0149\u014a"+
		"\7@\2\2\u014a\\\3\2\2\2\u014b\u014c\t\b\2\2\u014c^\3\2\2\2\u014d\u014e"+
		"\t\t\2\2\u014e`\3\2\2\2\u014f\u0150\t\n\2\2\u0150b\3\2\2\2\u0151\u0152"+
		"\t\13\2\2\u0152d\3\2\2\2\u0153\u0154\t\f\2\2\u0154f\3\2\2\2\u0155\u0156"+
		"\t\r\2\2\u0156h\3\2\2\2\u0157\u0158\t\16\2\2\u0158j\3\2\2\2\u0159\u015a"+
		"\t\17\2\2\u015al\3\2\2\2\u015b\u015c\t\20\2\2\u015cn\3\2\2\2\u015d\u015e"+
		"\t\21\2\2\u015ep\3\2\2\2\u015f\u0160\t\22\2\2\u0160r\3\2\2\2\u0161\u0162"+
		"\t\23\2\2\u0162t\3\2\2\2\u0163\u0164\t\24\2\2\u0164v\3\2\2\2\u0165\u0166"+
		"\t\25\2\2\u0166x\3\2\2\2\u0167\u0168\t\26\2\2\u0168z\3\2\2\2\u0169\u016a"+
		"\t\27\2\2\u016a|\3\2\2\2\u016b\u016c\t\30\2\2\u016c~\3\2\2\2\u016d\u0170"+
		"\7^\2\2\u016e\u0171\t\31\2\2\u016f\u0171\5\u0081A\2\u0170\u016e\3\2\2"+
		"\2\u0170\u016f\3\2\2\2\u0171\u0080\3\2\2\2\u0172\u0173\7w\2\2\u0173\u0174"+
		"\5\u0083B\2\u0174\u0175\5\u0083B\2\u0175\u0176\5\u0083B\2\u0176\u0177"+
		"\5\u0083B\2\u0177\u0082\3\2\2\2\u0178\u0179\t\32\2\2\u0179\u0084\3\2\2"+
		"\2\r\2\u00ab\u00b4\u00b6\u00c4\u012b\u012d\u0135\u013b\u0142\u0170\4\b"+
		"\2\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}