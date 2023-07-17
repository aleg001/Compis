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
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, TYPE=36, ID=37, INTEGER=38, STRING=39, 
		WS=40;
	public static final int
		RULE_program = 0, RULE_class = 1, RULE_feature = 2, RULE_formal = 3, RULE_expr = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "class", "feature", "formal", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'class'", "'inherits'", "'{'", "'}'", "'('", "','", "')'", "':'", 
			"';'", "'<-'", "'['", "']'", "'.'", "'if'", "'then'", "'else'", "'fi'", 
			"'while'", "'loop'", "'pool'", "'let'", "'in'", "'new'", "'isvoid'", 
			"'+'", "'-'", "'*'", "'/'", "'~'", "'<'", "'<='", "'='", "'not'", "'true'", 
			"'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"TYPE", "ID", "INTEGER", "STRING", "WS"
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
		public List<ClassContext> class() {
			return getRuleContexts(ClassContext.class);
		}
		public ClassContext class(int i) {
			return getRuleContext(ClassContext.class,i);
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
			setState(11); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(10);
				class();
				}
				}
				setState(13); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 );
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

	public static class ClassContext extends ParserRuleContext {
		public List<TerminalNode> TYPE() { return getTokens(yaplParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(yaplParser.TYPE, i);
		}
		public List<FeatureContext> feature() {
			return getRuleContexts(FeatureContext.class);
		}
		public FeatureContext feature(int i) {
			return getRuleContext(FeatureContext.class,i);
		}
		public ClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class; }
	}

	public final ClassContext class() throws RecognitionException {
		ClassContext _localctx = new ClassContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_class);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15);
			match(T__0);
			setState(16);
			match(TYPE);
			setState(19);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(17);
				match(T__1);
				setState(18);
				match(TYPE);
				}
			}

			setState(21);
			match(T__2);
			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(22);
				feature();
				}
				}
				setState(27);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(28);
			match(T__3);
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
		public TerminalNode ID() { return getToken(yaplParser.ID, 0); }
		public TerminalNode TYPE() { return getToken(yaplParser.TYPE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
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
			setState(57);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(30);
				match(ID);
				setState(31);
				match(T__4);
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(32);
					formal();
					setState(37);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__5) {
						{
						{
						setState(33);
						match(T__5);
						setState(34);
						formal();
						}
						}
						setState(39);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(42);
				match(T__6);
				setState(43);
				match(T__7);
				setState(44);
				match(TYPE);
				setState(45);
				match(T__2);
				setState(46);
				expr(0);
				setState(47);
				match(T__3);
				setState(48);
				match(T__8);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(50);
				match(ID);
				setState(51);
				match(T__7);
				setState(52);
				match(TYPE);
				setState(53);
				match(T__9);
				setState(54);
				expr(0);
				setState(55);
				match(T__8);
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
		public TerminalNode ID() { return getToken(yaplParser.ID, 0); }
		public TerminalNode TYPE() { return getToken(yaplParser.TYPE, 0); }
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
			setState(59);
			match(ID);
			setState(60);
			match(T__7);
			setState(61);
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

	public static class ExprContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(yaplParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(yaplParser.ID, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> TYPE() { return getTokens(yaplParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(yaplParser.TYPE, i);
		}
		public TerminalNode INTEGER() { return getToken(yaplParser.INTEGER, 0); }
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
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(64);
				match(ID);
				setState(65);
				match(T__9);
				setState(66);
				expr(24);
				}
				break;
			case 2:
				{
				setState(67);
				match(ID);
				setState(68);
				match(T__4);
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__4) | (1L << T__13) | (1L << T__17) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__28) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << ID) | (1L << INTEGER) | (1L << STRING))) != 0)) {
					{
					setState(69);
					expr(0);
					setState(74);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__5) {
						{
						{
						setState(70);
						match(T__5);
						setState(71);
						expr(0);
						}
						}
						setState(76);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(79);
				match(T__6);
				}
				break;
			case 3:
				{
				setState(80);
				match(T__13);
				setState(81);
				expr(0);
				setState(82);
				match(T__14);
				setState(83);
				expr(0);
				setState(84);
				match(T__15);
				setState(85);
				expr(0);
				setState(86);
				match(T__16);
				}
				break;
			case 4:
				{
				setState(88);
				match(T__17);
				setState(89);
				expr(0);
				setState(90);
				match(T__18);
				setState(91);
				expr(0);
				setState(92);
				match(T__19);
				}
				break;
			case 5:
				{
				setState(94);
				match(T__2);
				setState(96); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(95);
					expr(0);
					}
					}
					setState(98); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__4) | (1L << T__13) | (1L << T__17) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__28) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << ID) | (1L << INTEGER) | (1L << STRING))) != 0) );
				setState(100);
				match(T__3);
				}
				break;
			case 6:
				{
				setState(102);
				match(T__20);
				setState(103);
				match(ID);
				setState(104);
				match(T__7);
				setState(105);
				match(TYPE);
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__9) {
					{
					setState(106);
					match(T__9);
					setState(107);
					expr(0);
					}
				}

				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(110);
					match(T__5);
					setState(111);
					match(ID);
					setState(112);
					match(T__7);
					setState(113);
					match(TYPE);
					setState(116);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__9) {
						{
						setState(114);
						match(T__9);
						setState(115);
						expr(0);
						}
					}

					}
					}
					setState(122);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(123);
				match(T__21);
				setState(124);
				expr(18);
				}
				break;
			case 7:
				{
				setState(125);
				match(T__22);
				setState(126);
				match(TYPE);
				}
				break;
			case 8:
				{
				setState(127);
				match(T__23);
				setState(128);
				expr(16);
				}
				break;
			case 9:
				{
				setState(129);
				match(T__28);
				setState(130);
				expr(11);
				}
				break;
			case 10:
				{
				setState(131);
				match(T__32);
				setState(132);
				expr(7);
				}
				break;
			case 11:
				{
				setState(133);
				match(T__4);
				setState(134);
				expr(0);
				setState(135);
				match(T__6);
				}
				break;
			case 12:
				{
				setState(137);
				match(ID);
				}
				break;
			case 13:
				{
				setState(138);
				match(INTEGER);
				}
				break;
			case 14:
				{
				setState(139);
				match(STRING);
				}
				break;
			case 15:
				{
				setState(140);
				match(T__33);
				}
				break;
			case 16:
				{
				setState(141);
				match(T__34);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(185);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(183);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(144);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(145);
						match(T__24);
						setState(146);
						expr(16);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(147);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(148);
						match(T__25);
						setState(149);
						expr(15);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(150);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(151);
						match(T__26);
						setState(152);
						expr(14);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(153);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(154);
						match(T__27);
						setState(155);
						expr(13);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(156);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(157);
						match(T__29);
						setState(158);
						expr(11);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(159);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(160);
						match(T__30);
						setState(161);
						expr(10);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(162);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(163);
						match(T__31);
						setState(164);
						expr(9);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(165);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(166);
						match(T__10);
						setState(167);
						match(TYPE);
						setState(168);
						match(T__11);
						setState(169);
						match(T__12);
						setState(170);
						match(ID);
						setState(171);
						match(T__4);
						setState(180);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__4) | (1L << T__13) | (1L << T__17) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__28) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << ID) | (1L << INTEGER) | (1L << STRING))) != 0)) {
							{
							setState(172);
							expr(0);
							setState(177);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==T__5) {
								{
								{
								setState(173);
								match(T__5);
								setState(174);
								expr(0);
								}
								}
								setState(179);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(182);
						match(T__6);
						}
						break;
					}
					} 
				}
				setState(187);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 15);
		case 1:
			return precpred(_ctx, 14);
		case 2:
			return precpred(_ctx, 13);
		case 3:
			return precpred(_ctx, 12);
		case 4:
			return precpred(_ctx, 10);
		case 5:
			return precpred(_ctx, 9);
		case 6:
			return precpred(_ctx, 8);
		case 7:
			return precpred(_ctx, 23);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3*\u00bf\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\6\2\16\n\2\r\2\16\2\17\3\3\3\3\3\3"+
		"\3\3\5\3\26\n\3\3\3\3\3\7\3\32\n\3\f\3\16\3\35\13\3\3\3\3\3\3\4\3\4\3"+
		"\4\3\4\3\4\7\4&\n\4\f\4\16\4)\13\4\5\4+\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4<\n\4\3\5\3\5\3\5\3\5\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6K\n\6\f\6\16\6N\13\6\5\6P\n\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\6\6c\n\6\r"+
		"\6\16\6d\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6o\n\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\5\6w\n\6\7\6y\n\6\f\6\16\6|\13\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u0091\n\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u00b2\n\6\f\6\16\6\u00b5"+
		"\13\6\5\6\u00b7\n\6\3\6\7\6\u00ba\n\6\f\6\16\6\u00bd\13\6\3\6\2\3\n\7"+
		"\2\4\6\b\n\2\2\2\u00de\2\r\3\2\2\2\4\21\3\2\2\2\6;\3\2\2\2\b=\3\2\2\2"+
		"\n\u0090\3\2\2\2\f\16\5\4\3\2\r\f\3\2\2\2\16\17\3\2\2\2\17\r\3\2\2\2\17"+
		"\20\3\2\2\2\20\3\3\2\2\2\21\22\7\3\2\2\22\25\7&\2\2\23\24\7\4\2\2\24\26"+
		"\7&\2\2\25\23\3\2\2\2\25\26\3\2\2\2\26\27\3\2\2\2\27\33\7\5\2\2\30\32"+
		"\5\6\4\2\31\30\3\2\2\2\32\35\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\36"+
		"\3\2\2\2\35\33\3\2\2\2\36\37\7\6\2\2\37\5\3\2\2\2 !\7\'\2\2!*\7\7\2\2"+
		"\"\'\5\b\5\2#$\7\b\2\2$&\5\b\5\2%#\3\2\2\2&)\3\2\2\2\'%\3\2\2\2\'(\3\2"+
		"\2\2(+\3\2\2\2)\'\3\2\2\2*\"\3\2\2\2*+\3\2\2\2+,\3\2\2\2,-\7\t\2\2-.\7"+
		"\n\2\2./\7&\2\2/\60\7\5\2\2\60\61\5\n\6\2\61\62\7\6\2\2\62\63\7\13\2\2"+
		"\63<\3\2\2\2\64\65\7\'\2\2\65\66\7\n\2\2\66\67\7&\2\2\678\7\f\2\289\5"+
		"\n\6\29:\7\13\2\2:<\3\2\2\2; \3\2\2\2;\64\3\2\2\2<\7\3\2\2\2=>\7\'\2\2"+
		">?\7\n\2\2?@\7&\2\2@\t\3\2\2\2AB\b\6\1\2BC\7\'\2\2CD\7\f\2\2D\u0091\5"+
		"\n\6\32EF\7\'\2\2FO\7\7\2\2GL\5\n\6\2HI\7\b\2\2IK\5\n\6\2JH\3\2\2\2KN"+
		"\3\2\2\2LJ\3\2\2\2LM\3\2\2\2MP\3\2\2\2NL\3\2\2\2OG\3\2\2\2OP\3\2\2\2P"+
		"Q\3\2\2\2Q\u0091\7\t\2\2RS\7\20\2\2ST\5\n\6\2TU\7\21\2\2UV\5\n\6\2VW\7"+
		"\22\2\2WX\5\n\6\2XY\7\23\2\2Y\u0091\3\2\2\2Z[\7\24\2\2[\\\5\n\6\2\\]\7"+
		"\25\2\2]^\5\n\6\2^_\7\26\2\2_\u0091\3\2\2\2`b\7\5\2\2ac\5\n\6\2ba\3\2"+
		"\2\2cd\3\2\2\2db\3\2\2\2de\3\2\2\2ef\3\2\2\2fg\7\6\2\2g\u0091\3\2\2\2"+
		"hi\7\27\2\2ij\7\'\2\2jk\7\n\2\2kn\7&\2\2lm\7\f\2\2mo\5\n\6\2nl\3\2\2\2"+
		"no\3\2\2\2oz\3\2\2\2pq\7\b\2\2qr\7\'\2\2rs\7\n\2\2sv\7&\2\2tu\7\f\2\2"+
		"uw\5\n\6\2vt\3\2\2\2vw\3\2\2\2wy\3\2\2\2xp\3\2\2\2y|\3\2\2\2zx\3\2\2\2"+
		"z{\3\2\2\2{}\3\2\2\2|z\3\2\2\2}~\7\30\2\2~\u0091\5\n\6\24\177\u0080\7"+
		"\31\2\2\u0080\u0091\7&\2\2\u0081\u0082\7\32\2\2\u0082\u0091\5\n\6\22\u0083"+
		"\u0084\7\37\2\2\u0084\u0091\5\n\6\r\u0085\u0086\7#\2\2\u0086\u0091\5\n"+
		"\6\t\u0087\u0088\7\7\2\2\u0088\u0089\5\n\6\2\u0089\u008a\7\t\2\2\u008a"+
		"\u0091\3\2\2\2\u008b\u0091\7\'\2\2\u008c\u0091\7(\2\2\u008d\u0091\7)\2"+
		"\2\u008e\u0091\7$\2\2\u008f\u0091\7%\2\2\u0090A\3\2\2\2\u0090E\3\2\2\2"+
		"\u0090R\3\2\2\2\u0090Z\3\2\2\2\u0090`\3\2\2\2\u0090h\3\2\2\2\u0090\177"+
		"\3\2\2\2\u0090\u0081\3\2\2\2\u0090\u0083\3\2\2\2\u0090\u0085\3\2\2\2\u0090"+
		"\u0087\3\2\2\2\u0090\u008b\3\2\2\2\u0090\u008c\3\2\2\2\u0090\u008d\3\2"+
		"\2\2\u0090\u008e\3\2\2\2\u0090\u008f\3\2\2\2\u0091\u00bb\3\2\2\2\u0092"+
		"\u0093\f\21\2\2\u0093\u0094\7\33\2\2\u0094\u00ba\5\n\6\22\u0095\u0096"+
		"\f\20\2\2\u0096\u0097\7\34\2\2\u0097\u00ba\5\n\6\21\u0098\u0099\f\17\2"+
		"\2\u0099\u009a\7\35\2\2\u009a\u00ba\5\n\6\20\u009b\u009c\f\16\2\2\u009c"+
		"\u009d\7\36\2\2\u009d\u00ba\5\n\6\17\u009e\u009f\f\f\2\2\u009f\u00a0\7"+
		" \2\2\u00a0\u00ba\5\n\6\r\u00a1\u00a2\f\13\2\2\u00a2\u00a3\7!\2\2\u00a3"+
		"\u00ba\5\n\6\f\u00a4\u00a5\f\n\2\2\u00a5\u00a6\7\"\2\2\u00a6\u00ba\5\n"+
		"\6\13\u00a7\u00a8\f\31\2\2\u00a8\u00a9\7\r\2\2\u00a9\u00aa\7&\2\2\u00aa"+
		"\u00ab\7\16\2\2\u00ab\u00ac\7\17\2\2\u00ac\u00ad\7\'\2\2\u00ad\u00b6\7"+
		"\7\2\2\u00ae\u00b3\5\n\6\2\u00af\u00b0\7\b\2\2\u00b0\u00b2\5\n\6\2\u00b1"+
		"\u00af\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2"+
		"\2\2\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00ae\3\2\2\2\u00b6"+
		"\u00b7\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00ba\7\t\2\2\u00b9\u0092\3\2"+
		"\2\2\u00b9\u0095\3\2\2\2\u00b9\u0098\3\2\2\2\u00b9\u009b\3\2\2\2\u00b9"+
		"\u009e\3\2\2\2\u00b9\u00a1\3\2\2\2\u00b9\u00a4\3\2\2\2\u00b9\u00a7\3\2"+
		"\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc"+
		"\13\3\2\2\2\u00bd\u00bb\3\2\2\2\23\17\25\33\'*;LOdnvz\u0090\u00b3\u00b6"+
		"\u00b9\u00bb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}