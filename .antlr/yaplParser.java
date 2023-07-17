// Generated from /Users/alegomez/Documents/UVG/Cuarto Año/Segundo Semestre/Compis/Compis/yapl.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class yaplParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, INT=20, ID=21, TYPE_ID=22, OBJECT_ID=23, STRING=24, 
		WS=25, CLASS=26, ELSE=27, ESAC=28, FALSE=29, FI=30, IF=31, IN=32, INHERITS=33, 
		ISVOID=34, LET=35, LOOP=36, NEW=37, NOT=38, OF=39, POOL=40, THEN=41, TRUE=42, 
		WHILE=43, CASE=44;
	public static final int
		RULE_program = 0, RULE_class_list = 1, RULE_class_def = 2, RULE_feature_body = 3, 
		RULE_feature_def = 4, RULE_feature_list = 5, RULE_formal_list = 6, RULE_formal_param = 7, 
		RULE_expr_list = 8, RULE_expr = 9, RULE_case_list = 10, RULE_case_def = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "class_list", "class_def", "feature_body", "feature_def", 
			"feature_list", "formal_list", "formal_param", "expr_list", "expr", "case_list", 
			"case_def"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'='", "'('", "')'", "':'", "';'", "','", "'<-'", 
			"'.'", "'@'", "'~'", "'*'", "'/'", "'+'", "'-'", "'<='", "'<'", "'=>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "INT", "ID", "TYPE_ID", 
			"OBJECT_ID", "STRING", "WS", "CLASS", "ELSE", "ESAC", "FALSE", "FI", 
			"IF", "IN", "INHERITS", "ISVOID", "LET", "LOOP", "NEW", "NOT", "OF", 
			"POOL", "THEN", "TRUE", "WHILE", "CASE"
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

	@Override
	public String getGrammarFileName() { return "yapl.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public yaplParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public Class_listContext class_list() {
			return getRuleContext(Class_listContext.class,0);
		}
		public TerminalNode EOF() { return getToken(yaplParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			class_list();
			setState(25);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Class_listContext extends ParserRuleContext {
		public List<Class_defContext> class_def() {
			return getRuleContexts(Class_defContext.class);
		}
		public Class_defContext class_def(int i) {
			return getRuleContext(Class_defContext.class,i);
		}
		public Class_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_list; }
	}

	public final Class_listContext class_list() throws RecognitionException {
		Class_listContext _localctx = new Class_listContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_class_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(27);
				class_def();
				}
				}
				setState(30); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CLASS );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Class_defContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(yaplParser.CLASS, 0); }
		public List<TerminalNode> TYPE_ID() { return getTokens(yaplParser.TYPE_ID); }
		public TerminalNode TYPE_ID(int i) {
			return getToken(yaplParser.TYPE_ID, i);
		}
		public Feature_listContext feature_list() {
			return getRuleContext(Feature_listContext.class,0);
		}
		public TerminalNode INHERITS() { return getToken(yaplParser.INHERITS, 0); }
		public Class_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_def; }
	}

	public final Class_defContext class_def() throws RecognitionException {
		Class_defContext _localctx = new Class_defContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_class_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(CLASS);
			setState(33);
			match(TYPE_ID);
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INHERITS) {
				{
				setState(34);
				match(INHERITS);
				setState(35);
				match(TYPE_ID);
				}
			}

			setState(38);
			match(T__0);
			setState(39);
			feature_list();
			setState(40);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Feature_bodyContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Formal_listContext formal_list() {
			return getRuleContext(Formal_listContext.class,0);
		}
		public TerminalNode TYPE_ID() { return getToken(yaplParser.TYPE_ID, 0); }
		public Expr_listContext expr_list() {
			return getRuleContext(Expr_listContext.class,0);
		}
		public Feature_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feature_body; }
	}

	public final Feature_bodyContext feature_body() throws RecognitionException {
		Feature_bodyContext _localctx = new Feature_bodyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_feature_body);
		try {
			setState(57);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(42);
				match(T__2);
				setState(43);
				expr(0);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				match(T__3);
				setState(45);
				formal_list();
				setState(46);
				match(T__4);
				setState(47);
				match(T__5);
				setState(48);
				match(TYPE_ID);
				setState(49);
				match(T__0);
				setState(50);
				expr_list();
				setState(51);
				match(T__1);
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 3);
				{
				setState(53);
				match(T__0);
				setState(54);
				expr_list();
				setState(55);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Feature_defContext extends ParserRuleContext {
		public TerminalNode OBJECT_ID() { return getToken(yaplParser.OBJECT_ID, 0); }
		public TerminalNode TYPE_ID() { return getToken(yaplParser.TYPE_ID, 0); }
		public Feature_bodyContext feature_body() {
			return getRuleContext(Feature_bodyContext.class,0);
		}
		public Feature_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feature_def; }
	}

	public final Feature_defContext feature_def() throws RecognitionException {
		Feature_defContext _localctx = new Feature_defContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_feature_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(OBJECT_ID);
			setState(60);
			match(T__5);
			setState(61);
			match(TYPE_ID);
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__3))) != 0)) {
				{
				setState(62);
				feature_body();
				}
			}

			setState(65);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Feature_listContext extends ParserRuleContext {
		public List<Feature_defContext> feature_def() {
			return getRuleContexts(Feature_defContext.class);
		}
		public Feature_defContext feature_def(int i) {
			return getRuleContext(Feature_defContext.class,i);
		}
		public Feature_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feature_list; }
	}

	public final Feature_listContext feature_list() throws RecognitionException {
		Feature_listContext _localctx = new Feature_listContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_feature_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OBJECT_ID) {
				{
				{
				setState(67);
				feature_def();
				}
				}
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Formal_listContext extends ParserRuleContext {
		public List<Formal_paramContext> formal_param() {
			return getRuleContexts(Formal_paramContext.class);
		}
		public Formal_paramContext formal_param(int i) {
			return getRuleContext(Formal_paramContext.class,i);
		}
		public Formal_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formal_list; }
	}

	public final Formal_listContext formal_list() throws RecognitionException {
		Formal_listContext _localctx = new Formal_listContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_formal_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			formal_param();
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(74);
				match(T__7);
				setState(75);
				formal_param();
				}
				}
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Formal_paramContext extends ParserRuleContext {
		public TerminalNode OBJECT_ID() { return getToken(yaplParser.OBJECT_ID, 0); }
		public TerminalNode TYPE_ID() { return getToken(yaplParser.TYPE_ID, 0); }
		public Formal_paramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formal_param; }
	}

	public final Formal_paramContext formal_param() throws RecognitionException {
		Formal_paramContext _localctx = new Formal_paramContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_formal_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(OBJECT_ID);
			setState(82);
			match(T__5);
			setState(83);
			match(TYPE_ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr_listContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Expr_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_list; }
	}

	public final Expr_listContext expr_list() throws RecognitionException {
		Expr_listContext _localctx = new Expr_listContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expr_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			expr(0);
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(86);
				match(T__6);
				setState(87);
				expr(0);
				}
				}
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(yaplParser.IF, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode THEN() { return getToken(yaplParser.THEN, 0); }
		public TerminalNode ELSE() { return getToken(yaplParser.ELSE, 0); }
		public TerminalNode FI() { return getToken(yaplParser.FI, 0); }
		public TerminalNode WHILE() { return getToken(yaplParser.WHILE, 0); }
		public TerminalNode LOOP() { return getToken(yaplParser.LOOP, 0); }
		public TerminalNode POOL() { return getToken(yaplParser.POOL, 0); }
		public Expr_listContext expr_list() {
			return getRuleContext(Expr_listContext.class,0);
		}
		public TerminalNode LET() { return getToken(yaplParser.LET, 0); }
		public List<TerminalNode> OBJECT_ID() { return getTokens(yaplParser.OBJECT_ID); }
		public TerminalNode OBJECT_ID(int i) {
			return getToken(yaplParser.OBJECT_ID, i);
		}
		public List<TerminalNode> TYPE_ID() { return getTokens(yaplParser.TYPE_ID); }
		public TerminalNode TYPE_ID(int i) {
			return getToken(yaplParser.TYPE_ID, i);
		}
		public TerminalNode IN() { return getToken(yaplParser.IN, 0); }
		public TerminalNode CASE() { return getToken(yaplParser.CASE, 0); }
		public TerminalNode OF() { return getToken(yaplParser.OF, 0); }
		public Case_listContext case_list() {
			return getRuleContext(Case_listContext.class,0);
		}
		public TerminalNode ESAC() { return getToken(yaplParser.ESAC, 0); }
		public TerminalNode NEW() { return getToken(yaplParser.NEW, 0); }
		public TerminalNode ISVOID() { return getToken(yaplParser.ISVOID, 0); }
		public TerminalNode NOT() { return getToken(yaplParser.NOT, 0); }
		public TerminalNode INT() { return getToken(yaplParser.INT, 0); }
		public TerminalNode TRUE() { return getToken(yaplParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(yaplParser.FALSE, 0); }
		public TerminalNode STRING() { return getToken(yaplParser.STRING, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				{
				setState(94);
				match(IF);
				setState(95);
				expr(0);
				setState(96);
				match(THEN);
				setState(97);
				expr(0);
				setState(98);
				match(ELSE);
				setState(99);
				expr(0);
				setState(100);
				match(FI);
				}
				break;
			case WHILE:
				{
				setState(102);
				match(WHILE);
				setState(103);
				expr(0);
				setState(104);
				match(LOOP);
				setState(105);
				expr(0);
				setState(106);
				match(POOL);
				}
				break;
			case T__0:
				{
				setState(108);
				match(T__0);
				setState(109);
				expr_list();
				setState(110);
				match(T__1);
				}
				break;
			case LET:
				{
				setState(112);
				match(LET);
				setState(113);
				match(OBJECT_ID);
				setState(114);
				match(T__5);
				setState(115);
				match(TYPE_ID);
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(116);
					match(T__8);
					setState(117);
					expr(0);
					}
				}

				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(120);
					match(T__7);
					setState(121);
					match(OBJECT_ID);
					setState(122);
					match(T__5);
					setState(123);
					match(TYPE_ID);
					setState(126);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__8) {
						{
						setState(124);
						match(T__8);
						setState(125);
						expr(0);
						}
					}

					}
					}
					setState(132);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(133);
				match(IN);
				setState(134);
				expr(22);
				}
				break;
			case CASE:
				{
				setState(135);
				match(CASE);
				setState(136);
				expr(0);
				setState(137);
				match(OF);
				setState(138);
				case_list();
				setState(139);
				match(ESAC);
				}
				break;
			case NEW:
				{
				setState(141);
				match(NEW);
				setState(142);
				match(TYPE_ID);
				}
				break;
			case ISVOID:
				{
				setState(143);
				match(ISVOID);
				setState(144);
				expr(19);
				}
				break;
			case NOT:
				{
				setState(145);
				match(NOT);
				setState(146);
				expr(15);
				}
				break;
			case T__3:
				{
				setState(147);
				match(T__3);
				setState(148);
				expr(0);
				setState(149);
				match(T__4);
				}
				break;
			case OBJECT_ID:
				{
				setState(151);
				match(OBJECT_ID);
				}
				break;
			case INT:
				{
				setState(152);
				match(INT);
				}
				break;
			case TRUE:
				{
				setState(153);
				match(TRUE);
				}
				break;
			case FALSE:
				{
				setState(154);
				match(FALSE);
				}
				break;
			case STRING:
				{
				setState(155);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(201);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(199);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(158);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(159);
						match(T__12);
						setState(160);
						expr(15);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(161);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(162);
						match(T__13);
						setState(163);
						expr(14);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(164);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(165);
						match(T__14);
						setState(166);
						expr(13);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(167);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(168);
						match(T__15);
						setState(169);
						expr(12);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(170);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(171);
						match(T__16);
						setState(172);
						expr(11);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(173);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(174);
						match(T__17);
						setState(175);
						expr(10);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(176);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(177);
						match(T__2);
						setState(178);
						expr(9);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(179);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(180);
						match(T__9);
						setState(181);
						match(OBJECT_ID);
						setState(182);
						match(T__3);
						setState(183);
						expr_list();
						setState(184);
						match(T__4);
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(186);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(187);
						match(T__10);
						setState(188);
						match(TYPE_ID);
						setState(189);
						match(T__9);
						setState(190);
						match(OBJECT_ID);
						setState(191);
						match(T__3);
						setState(192);
						expr_list();
						setState(193);
						match(T__4);
						}
						break;
					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(195);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(196);
						match(T__11);
						}
						break;
					case 11:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(197);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(198);
						match(ISVOID);
						}
						break;
					}
					} 
				}
				setState(203);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Case_listContext extends ParserRuleContext {
		public List<Case_defContext> case_def() {
			return getRuleContexts(Case_defContext.class);
		}
		public Case_defContext case_def(int i) {
			return getRuleContext(Case_defContext.class,i);
		}
		public Case_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_list; }
	}

	public final Case_listContext case_list() throws RecognitionException {
		Case_listContext _localctx = new Case_listContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_case_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(204);
				case_def();
				}
				}
				setState(207); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==OBJECT_ID );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Case_defContext extends ParserRuleContext {
		public TerminalNode OBJECT_ID() { return getToken(yaplParser.OBJECT_ID, 0); }
		public TerminalNode TYPE_ID() { return getToken(yaplParser.TYPE_ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Case_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_def; }
	}

	public final Case_defContext case_def() throws RecognitionException {
		Case_defContext _localctx = new Case_defContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_case_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			match(OBJECT_ID);
			setState(210);
			match(T__5);
			setState(211);
			match(TYPE_ID);
			setState(212);
			match(T__18);
			setState(213);
			expr(0);
			setState(214);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 9:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 14);
		case 1:
			return precpred(_ctx, 13);
		case 2:
			return precpred(_ctx, 12);
		case 3:
			return precpred(_ctx, 11);
		case 4:
			return precpred(_ctx, 10);
		case 5:
			return precpred(_ctx, 9);
		case 6:
			return precpred(_ctx, 8);
		case 7:
			return precpred(_ctx, 18);
		case 8:
			return precpred(_ctx, 17);
		case 9:
			return precpred(_ctx, 16);
		case 10:
			return precpred(_ctx, 7);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u00db\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\3\6\3\37\n\3\r\3\16\3 \3\4\3\4\3\4\3"+
		"\4\5\4\'\n\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\5\5<\n\5\3\6\3\6\3\6\3\6\5\6B\n\6\3\6\3\6\3\7\7\7G"+
		"\n\7\f\7\16\7J\13\7\3\b\3\b\3\b\7\bO\n\b\f\b\16\bR\13\b\3\t\3\t\3\t\3"+
		"\t\3\n\3\n\3\n\7\n[\n\n\f\n\16\n^\13\n\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\5\13y\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13"+
		"\u0081\n\13\7\13\u0083\n\13\f\13\16\13\u0086\13\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\5\13\u009f\n\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00ca\n\13\f\13\16\13\u00cd\13"+
		"\13\3\f\6\f\u00d0\n\f\r\f\16\f\u00d1\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\2"+
		"\3\24\16\2\4\6\b\n\f\16\20\22\24\26\30\2\2\2\u00f2\2\32\3\2\2\2\4\36\3"+
		"\2\2\2\6\"\3\2\2\2\b;\3\2\2\2\n=\3\2\2\2\fH\3\2\2\2\16K\3\2\2\2\20S\3"+
		"\2\2\2\22W\3\2\2\2\24\u009e\3\2\2\2\26\u00cf\3\2\2\2\30\u00d3\3\2\2\2"+
		"\32\33\5\4\3\2\33\34\7\2\2\3\34\3\3\2\2\2\35\37\5\6\4\2\36\35\3\2\2\2"+
		"\37 \3\2\2\2 \36\3\2\2\2 !\3\2\2\2!\5\3\2\2\2\"#\7\34\2\2#&\7\30\2\2$"+
		"%\7#\2\2%\'\7\30\2\2&$\3\2\2\2&\'\3\2\2\2\'(\3\2\2\2()\7\3\2\2)*\5\f\7"+
		"\2*+\7\4\2\2+\7\3\2\2\2,-\7\5\2\2-<\5\24\13\2./\7\6\2\2/\60\5\16\b\2\60"+
		"\61\7\7\2\2\61\62\7\b\2\2\62\63\7\30\2\2\63\64\7\3\2\2\64\65\5\22\n\2"+
		"\65\66\7\4\2\2\66<\3\2\2\2\678\7\3\2\289\5\22\n\29:\7\4\2\2:<\3\2\2\2"+
		";,\3\2\2\2;.\3\2\2\2;\67\3\2\2\2<\t\3\2\2\2=>\7\31\2\2>?\7\b\2\2?A\7\30"+
		"\2\2@B\5\b\5\2A@\3\2\2\2AB\3\2\2\2BC\3\2\2\2CD\7\t\2\2D\13\3\2\2\2EG\5"+
		"\n\6\2FE\3\2\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2I\r\3\2\2\2JH\3\2\2\2KP"+
		"\5\20\t\2LM\7\n\2\2MO\5\20\t\2NL\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2\2\2"+
		"Q\17\3\2\2\2RP\3\2\2\2ST\7\31\2\2TU\7\b\2\2UV\7\30\2\2V\21\3\2\2\2W\\"+
		"\5\24\13\2XY\7\t\2\2Y[\5\24\13\2ZX\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2"+
		"\2\2]\23\3\2\2\2^\\\3\2\2\2_`\b\13\1\2`a\7!\2\2ab\5\24\13\2bc\7+\2\2c"+
		"d\5\24\13\2de\7\35\2\2ef\5\24\13\2fg\7 \2\2g\u009f\3\2\2\2hi\7-\2\2ij"+
		"\5\24\13\2jk\7&\2\2kl\5\24\13\2lm\7*\2\2m\u009f\3\2\2\2no\7\3\2\2op\5"+
		"\22\n\2pq\7\4\2\2q\u009f\3\2\2\2rs\7%\2\2st\7\31\2\2tu\7\b\2\2ux\7\30"+
		"\2\2vw\7\13\2\2wy\5\24\13\2xv\3\2\2\2xy\3\2\2\2y\u0084\3\2\2\2z{\7\n\2"+
		"\2{|\7\31\2\2|}\7\b\2\2}\u0080\7\30\2\2~\177\7\13\2\2\177\u0081\5\24\13"+
		"\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0083\3\2\2\2\u0082z\3\2\2"+
		"\2\u0083\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0087"+
		"\3\2\2\2\u0086\u0084\3\2\2\2\u0087\u0088\7\"\2\2\u0088\u009f\5\24\13\30"+
		"\u0089\u008a\7.\2\2\u008a\u008b\5\24\13\2\u008b\u008c\7)\2\2\u008c\u008d"+
		"\5\26\f\2\u008d\u008e\7\36\2\2\u008e\u009f\3\2\2\2\u008f\u0090\7\'\2\2"+
		"\u0090\u009f\7\30\2\2\u0091\u0092\7$\2\2\u0092\u009f\5\24\13\25\u0093"+
		"\u0094\7(\2\2\u0094\u009f\5\24\13\21\u0095\u0096\7\6\2\2\u0096\u0097\5"+
		"\24\13\2\u0097\u0098\7\7\2\2\u0098\u009f\3\2\2\2\u0099\u009f\7\31\2\2"+
		"\u009a\u009f\7\26\2\2\u009b\u009f\7,\2\2\u009c\u009f\7\37\2\2\u009d\u009f"+
		"\7\32\2\2\u009e_\3\2\2\2\u009eh\3\2\2\2\u009en\3\2\2\2\u009er\3\2\2\2"+
		"\u009e\u0089\3\2\2\2\u009e\u008f\3\2\2\2\u009e\u0091\3\2\2\2\u009e\u0093"+
		"\3\2\2\2\u009e\u0095\3\2\2\2\u009e\u0099\3\2\2\2\u009e\u009a\3\2\2\2\u009e"+
		"\u009b\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009d\3\2\2\2\u009f\u00cb\3\2"+
		"\2\2\u00a0\u00a1\f\20\2\2\u00a1\u00a2\7\17\2\2\u00a2\u00ca\5\24\13\21"+
		"\u00a3\u00a4\f\17\2\2\u00a4\u00a5\7\20\2\2\u00a5\u00ca\5\24\13\20\u00a6"+
		"\u00a7\f\16\2\2\u00a7\u00a8\7\21\2\2\u00a8\u00ca\5\24\13\17\u00a9\u00aa"+
		"\f\r\2\2\u00aa\u00ab\7\22\2\2\u00ab\u00ca\5\24\13\16\u00ac\u00ad\f\f\2"+
		"\2\u00ad\u00ae\7\23\2\2\u00ae\u00ca\5\24\13\r\u00af\u00b0\f\13\2\2\u00b0"+
		"\u00b1\7\24\2\2\u00b1\u00ca\5\24\13\f\u00b2\u00b3\f\n\2\2\u00b3\u00b4"+
		"\7\5\2\2\u00b4\u00ca\5\24\13\13\u00b5\u00b6\f\24\2\2\u00b6\u00b7\7\f\2"+
		"\2\u00b7\u00b8\7\31\2\2\u00b8\u00b9\7\6\2\2\u00b9\u00ba\5\22\n\2\u00ba"+
		"\u00bb\7\7\2\2\u00bb\u00ca\3\2\2\2\u00bc\u00bd\f\23\2\2\u00bd\u00be\7"+
		"\r\2\2\u00be\u00bf\7\30\2\2\u00bf\u00c0\7\f\2\2\u00c0\u00c1\7\31\2\2\u00c1"+
		"\u00c2\7\6\2\2\u00c2\u00c3\5\22\n\2\u00c3\u00c4\7\7\2\2\u00c4\u00ca\3"+
		"\2\2\2\u00c5\u00c6\f\22\2\2\u00c6\u00ca\7\16\2\2\u00c7\u00c8\f\t\2\2\u00c8"+
		"\u00ca\7$\2\2\u00c9\u00a0\3\2\2\2\u00c9\u00a3\3\2\2\2\u00c9\u00a6\3\2"+
		"\2\2\u00c9\u00a9\3\2\2\2\u00c9\u00ac\3\2\2\2\u00c9\u00af\3\2\2\2\u00c9"+
		"\u00b2\3\2\2\2\u00c9\u00b5\3\2\2\2\u00c9\u00bc\3\2\2\2\u00c9\u00c5\3\2"+
		"\2\2\u00c9\u00c7\3\2\2\2\u00ca\u00cd\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb"+
		"\u00cc\3\2\2\2\u00cc\25\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ce\u00d0\5\30\r"+
		"\2\u00cf\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2"+
		"\3\2\2\2\u00d2\27\3\2\2\2\u00d3\u00d4\7\31\2\2\u00d4\u00d5\7\b\2\2\u00d5"+
		"\u00d6\7\30\2\2\u00d6\u00d7\7\25\2\2\u00d7\u00d8\5\24\13\2\u00d8\u00d9"+
		"\7\t\2\2\u00d9\31\3\2\2\2\20 &;AHP\\x\u0080\u0084\u009e\u00c9\u00cb\u00d1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}