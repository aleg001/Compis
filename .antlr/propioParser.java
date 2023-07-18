// Generated from /Users/alegomez/Documents/UVG/Cuarto Año/Segundo Semestre/Compis/Compis/propio.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class propioParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		CLASS=18, ELSE=19, FALSE=20, FI=21, IF=22, IN=23, INHERITS=24, ISVOID=25, 
		LOOP=26, POOL=27, THEN=28, WHILE=29, NEW=30, NOT=31, TRUE=32, STRING=33, 
		INT=34, TYPE=35, ID=36, WHITESPACE=37, BLOCK_COMMENT=38, LINE_COMMENT=39;
	public static final int
		RULE_program = 0, RULE_classkey = 1, RULE_feature = 2, RULE_formal = 3, 
		RULE_expression = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "classkey", "feature", "formal", "expression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'{'", "'}'", "'('", "','", "')'", "':'", "'<-'", "'@'", 
			"'.'", "'*'", "'/'", "'+'", "'-'", "'='", "'<'", "'~'", "'class'", "'else'", 
			"'false'", "'fi'", "'if'", "'in'", "'inherits'", "'isvoid'", "'loop'", 
			"'pool'", "'then'", "'while'", "'new'", "'not'", "'true'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "CLASS", "ELSE", "FALSE", "FI", "IF", 
			"IN", "INHERITS", "ISVOID", "LOOP", "POOL", "THEN", "WHILE", "NEW", "NOT", 
			"TRUE", "STRING", "INT", "TYPE", "ID", "WHITESPACE", "BLOCK_COMMENT", 
			"LINE_COMMENT"
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
	public String getGrammarFileName() { return "propio.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public propioParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(propioParser.EOF, 0); }
		public List<ClasskeyContext> classkey() {
			return getRuleContexts(ClasskeyContext.class);
		}
		public ClasskeyContext classkey(int i) {
			return getRuleContext(ClasskeyContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(10);
				classkey();
				setState(11);
				match(T__0);
				}
				}
				setState(15); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CLASS );
			setState(17);
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

	public static class ClasskeyContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(propioParser.CLASS, 0); }
		public List<TerminalNode> TYPE() { return getTokens(propioParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(propioParser.TYPE, i);
		}
		public TerminalNode INHERITS() { return getToken(propioParser.INHERITS, 0); }
		public List<FeatureContext> feature() {
			return getRuleContexts(FeatureContext.class);
		}
		public FeatureContext feature(int i) {
			return getRuleContext(FeatureContext.class,i);
		}
		public ClasskeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classkey; }
	}

	public final ClasskeyContext classkey() throws RecognitionException {
		ClasskeyContext _localctx = new ClasskeyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_classkey);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			match(CLASS);
			setState(20);
			match(TYPE);
			setState(23);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INHERITS) {
				{
				setState(21);
				match(INHERITS);
				setState(22);
				match(TYPE);
				}
			}

			setState(25);
			match(T__1);
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(26);
				feature();
				setState(27);
				match(T__0);
				}
				}
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(34);
			match(T__2);
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

	public static class FeatureContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(propioParser.ID, 0); }
		public TerminalNode TYPE() { return getToken(propioParser.TYPE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<FormalContext> formal() {
			return getRuleContexts(FormalContext.class);
		}
		public FormalContext formal(int i) {
			return getRuleContext(FormalContext.class,i);
		}
		public FeatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feature; }
	}

	public final FeatureContext feature() throws RecognitionException {
		FeatureContext _localctx = new FeatureContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_feature);
		int _la;
		try {
			setState(63);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(36);
				match(ID);
				setState(37);
				match(T__3);
				setState(48);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(38);
					formal();
					setState(43);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__4) {
						{
						{
						setState(39);
						match(T__4);
						setState(40);
						formal();
						}
						}
						setState(45);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					setState(50);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(51);
				match(T__5);
				setState(52);
				match(T__6);
				setState(53);
				match(TYPE);
				setState(54);
				match(T__1);
				setState(55);
				expression(0);
				setState(56);
				match(T__2);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				formal();
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__7) {
					{
					setState(59);
					match(T__7);
					setState(60);
					expression(0);
					}
				}

				}
				break;
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

	public static class FormalContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(propioParser.ID, 0); }
		public TerminalNode TYPE() { return getToken(propioParser.TYPE, 0); }
		public FormalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formal; }
	}

	public final FormalContext formal() throws RecognitionException {
		FormalContext _localctx = new FormalContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_formal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(ID);
			setState(66);
			match(T__6);
			setState(67);
			match(TYPE);
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

	public static class ExpressionContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(propioParser.IF, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode THEN() { return getToken(propioParser.THEN, 0); }
		public TerminalNode ELSE() { return getToken(propioParser.ELSE, 0); }
		public TerminalNode FI() { return getToken(propioParser.FI, 0); }
		public TerminalNode ID() { return getToken(propioParser.ID, 0); }
		public TerminalNode WHILE() { return getToken(propioParser.WHILE, 0); }
		public TerminalNode LOOP() { return getToken(propioParser.LOOP, 0); }
		public TerminalNode POOL() { return getToken(propioParser.POOL, 0); }
		public TerminalNode ISVOID() { return getToken(propioParser.ISVOID, 0); }
		public TerminalNode NOT() { return getToken(propioParser.NOT, 0); }
		public TerminalNode NEW() { return getToken(propioParser.NEW, 0); }
		public TerminalNode TYPE() { return getToken(propioParser.TYPE, 0); }
		public TerminalNode STRING() { return getToken(propioParser.STRING, 0); }
		public TerminalNode FALSE() { return getToken(propioParser.FALSE, 0); }
		public TerminalNode TRUE() { return getToken(propioParser.TRUE, 0); }
		public TerminalNode INT() { return getToken(propioParser.INT, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(70);
				match(IF);
				setState(71);
				expression(0);
				setState(72);
				match(THEN);
				setState(73);
				expression(0);
				setState(74);
				match(ELSE);
				setState(75);
				expression(0);
				setState(76);
				match(FI);
				}
				break;
			case 2:
				{
				setState(78);
				match(ID);
				setState(79);
				match(T__3);
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__3) | (1L << T__16) | (1L << FALSE) | (1L << IF) | (1L << ISVOID) | (1L << WHILE) | (1L << NEW) | (1L << NOT) | (1L << TRUE) | (1L << STRING) | (1L << INT) | (1L << ID))) != 0)) {
					{
					{
					setState(80);
					expression(0);
					setState(85);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__4) {
						{
						{
						setState(81);
						match(T__4);
						setState(82);
						expression(0);
						}
						}
						setState(87);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					setState(92);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(93);
				match(T__5);
				}
				break;
			case 3:
				{
				setState(94);
				match(WHILE);
				setState(95);
				expression(0);
				setState(96);
				match(LOOP);
				setState(97);
				expression(0);
				setState(98);
				match(POOL);
				}
				break;
			case 4:
				{
				setState(100);
				match(T__1);
				setState(104); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(101);
					expression(0);
					setState(102);
					match(T__0);
					}
					}
					setState(106); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__3) | (1L << T__16) | (1L << FALSE) | (1L << IF) | (1L << ISVOID) | (1L << WHILE) | (1L << NEW) | (1L << NOT) | (1L << TRUE) | (1L << STRING) | (1L << INT) | (1L << ID))) != 0) );
				setState(108);
				match(T__2);
				}
				break;
			case 5:
				{
				setState(110);
				match(ID);
				setState(111);
				match(T__7);
				setState(112);
				expression(11);
				}
				break;
			case 6:
				{
				setState(113);
				match(ISVOID);
				setState(114);
				expression(10);
				}
				break;
			case 7:
				{
				setState(115);
				match(T__16);
				setState(116);
				expression(9);
				}
				break;
			case 8:
				{
				setState(117);
				match(NOT);
				setState(118);
				expression(8);
				}
				break;
			case 9:
				{
				setState(119);
				match(T__3);
				setState(120);
				expression(0);
				setState(121);
				match(T__5);
				}
				break;
			case 10:
				{
				setState(123);
				match(NEW);
				setState(124);
				match(TYPE);
				}
				break;
			case 11:
				{
				setState(125);
				match(STRING);
				}
				break;
			case 12:
				{
				setState(126);
				match(FALSE);
				}
				break;
			case 13:
				{
				setState(127);
				match(TRUE);
				}
				break;
			case 14:
				{
				setState(128);
				match(INT);
				}
				break;
			case 15:
				{
				setState(129);
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(171);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(169);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(132);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(133);
						_la = _input.LA(1);
						if ( !(_la==T__10 || _la==T__11) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(134);
						expression(18);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(135);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(136);
						_la = _input.LA(1);
						if ( !(_la==T__12 || _la==T__13) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(137);
						expression(17);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(138);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(139);
						match(T__7);
						setState(140);
						expression(16);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(141);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(142);
						match(T__14);
						setState(143);
						expression(14);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(144);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(145);
						match(T__15);
						setState(146);
						expression(13);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(147);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(150);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==T__8) {
							{
							setState(148);
							match(T__8);
							setState(149);
							match(TYPE);
							}
						}

						setState(152);
						match(T__9);
						setState(153);
						match(ID);
						setState(154);
						match(T__3);
						setState(165);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__3) | (1L << T__16) | (1L << FALSE) | (1L << IF) | (1L << ISVOID) | (1L << WHILE) | (1L << NEW) | (1L << NOT) | (1L << TRUE) | (1L << STRING) | (1L << INT) | (1L << ID))) != 0)) {
							{
							{
							setState(155);
							expression(0);
							setState(160);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==T__4) {
								{
								{
								setState(156);
								match(T__4);
								setState(157);
								expression(0);
								}
								}
								setState(162);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
							}
							setState(167);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(168);
						match(T__5);
						}
						break;
					}
					} 
				}
				setState(173);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 17);
		case 1:
			return precpred(_ctx, 16);
		case 2:
			return precpred(_ctx, 15);
		case 3:
			return precpred(_ctx, 13);
		case 4:
			return precpred(_ctx, 12);
		case 5:
			return precpred(_ctx, 21);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3)\u00b1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\6\2\20\n\2\r\2\16\2\21\3\2"+
		"\3\2\3\3\3\3\3\3\3\3\5\3\32\n\3\3\3\3\3\3\3\3\3\7\3 \n\3\f\3\16\3#\13"+
		"\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\7\4,\n\4\f\4\16\4/\13\4\7\4\61\n\4\f\4"+
		"\16\4\64\13\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4@\n\4\5\4B\n"+
		"\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\7\6V\n\6\f\6\16\6Y\13\6\7\6[\n\6\f\6\16\6^\13\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\6\6k\n\6\r\6\16\6l\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u0085"+
		"\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\5\6\u0099\n\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u00a1\n\6\f\6\16\6\u00a4"+
		"\13\6\7\6\u00a6\n\6\f\6\16\6\u00a9\13\6\3\6\7\6\u00ac\n\6\f\6\16\6\u00af"+
		"\13\6\3\6\2\3\n\7\2\4\6\b\n\2\4\3\2\r\16\3\2\17\20\2\u00cc\2\17\3\2\2"+
		"\2\4\25\3\2\2\2\6A\3\2\2\2\bC\3\2\2\2\n\u0084\3\2\2\2\f\r\5\4\3\2\r\16"+
		"\7\3\2\2\16\20\3\2\2\2\17\f\3\2\2\2\20\21\3\2\2\2\21\17\3\2\2\2\21\22"+
		"\3\2\2\2\22\23\3\2\2\2\23\24\7\2\2\3\24\3\3\2\2\2\25\26\7\24\2\2\26\31"+
		"\7%\2\2\27\30\7\32\2\2\30\32\7%\2\2\31\27\3\2\2\2\31\32\3\2\2\2\32\33"+
		"\3\2\2\2\33!\7\4\2\2\34\35\5\6\4\2\35\36\7\3\2\2\36 \3\2\2\2\37\34\3\2"+
		"\2\2 #\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"$\3\2\2\2#!\3\2\2\2$%\7\5\2\2%"+
		"\5\3\2\2\2&\'\7&\2\2\'\62\7\6\2\2(-\5\b\5\2)*\7\7\2\2*,\5\b\5\2+)\3\2"+
		"\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\61\3\2\2\2/-\3\2\2\2\60(\3\2\2\2\61"+
		"\64\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63\65\3\2\2\2\64\62\3\2\2\2\65"+
		"\66\7\b\2\2\66\67\7\t\2\2\678\7%\2\289\7\4\2\29:\5\n\6\2:;\7\5\2\2;B\3"+
		"\2\2\2<?\5\b\5\2=>\7\n\2\2>@\5\n\6\2?=\3\2\2\2?@\3\2\2\2@B\3\2\2\2A&\3"+
		"\2\2\2A<\3\2\2\2B\7\3\2\2\2CD\7&\2\2DE\7\t\2\2EF\7%\2\2F\t\3\2\2\2GH\b"+
		"\6\1\2HI\7\30\2\2IJ\5\n\6\2JK\7\36\2\2KL\5\n\6\2LM\7\25\2\2MN\5\n\6\2"+
		"NO\7\27\2\2O\u0085\3\2\2\2PQ\7&\2\2Q\\\7\6\2\2RW\5\n\6\2ST\7\7\2\2TV\5"+
		"\n\6\2US\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2X[\3\2\2\2YW\3\2\2\2ZR\3"+
		"\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]_\3\2\2\2^\\\3\2\2\2_\u0085\7\b"+
		"\2\2`a\7\37\2\2ab\5\n\6\2bc\7\34\2\2cd\5\n\6\2de\7\35\2\2e\u0085\3\2\2"+
		"\2fj\7\4\2\2gh\5\n\6\2hi\7\3\2\2ik\3\2\2\2jg\3\2\2\2kl\3\2\2\2lj\3\2\2"+
		"\2lm\3\2\2\2mn\3\2\2\2no\7\5\2\2o\u0085\3\2\2\2pq\7&\2\2qr\7\n\2\2r\u0085"+
		"\5\n\6\rst\7\33\2\2t\u0085\5\n\6\fuv\7\23\2\2v\u0085\5\n\6\13wx\7!\2\2"+
		"x\u0085\5\n\6\nyz\7\6\2\2z{\5\n\6\2{|\7\b\2\2|\u0085\3\2\2\2}~\7 \2\2"+
		"~\u0085\7%\2\2\177\u0085\7#\2\2\u0080\u0085\7\26\2\2\u0081\u0085\7\"\2"+
		"\2\u0082\u0085\7$\2\2\u0083\u0085\7&\2\2\u0084G\3\2\2\2\u0084P\3\2\2\2"+
		"\u0084`\3\2\2\2\u0084f\3\2\2\2\u0084p\3\2\2\2\u0084s\3\2\2\2\u0084u\3"+
		"\2\2\2\u0084w\3\2\2\2\u0084y\3\2\2\2\u0084}\3\2\2\2\u0084\177\3\2\2\2"+
		"\u0084\u0080\3\2\2\2\u0084\u0081\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0083"+
		"\3\2\2\2\u0085\u00ad\3\2\2\2\u0086\u0087\f\23\2\2\u0087\u0088\t\2\2\2"+
		"\u0088\u00ac\5\n\6\24\u0089\u008a\f\22\2\2\u008a\u008b\t\3\2\2\u008b\u00ac"+
		"\5\n\6\23\u008c\u008d\f\21\2\2\u008d\u008e\7\n\2\2\u008e\u00ac\5\n\6\22"+
		"\u008f\u0090\f\17\2\2\u0090\u0091\7\21\2\2\u0091\u00ac\5\n\6\20\u0092"+
		"\u0093\f\16\2\2\u0093\u0094\7\22\2\2\u0094\u00ac\5\n\6\17\u0095\u0098"+
		"\f\27\2\2\u0096\u0097\7\13\2\2\u0097\u0099\7%\2\2\u0098\u0096\3\2\2\2"+
		"\u0098\u0099\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b\7\f\2\2\u009b\u009c"+
		"\7&\2\2\u009c\u00a7\7\6\2\2\u009d\u00a2\5\n\6\2\u009e\u009f\7\7\2\2\u009f"+
		"\u00a1\5\n\6\2\u00a0\u009e\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a0\3\2"+
		"\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5"+
		"\u009d\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2"+
		"\2\2\u00a8\u00aa\3\2\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00ac\7\b\2\2\u00ab"+
		"\u0086\3\2\2\2\u00ab\u0089\3\2\2\2\u00ab\u008c\3\2\2\2\u00ab\u008f\3\2"+
		"\2\2\u00ab\u0092\3\2\2\2\u00ab\u0095\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad"+
		"\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\13\3\2\2\2\u00af\u00ad\3\2\2"+
		"\2\22\21\31!-\62?AW\\l\u0084\u0098\u00a2\u00a7\u00ab\u00ad";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}