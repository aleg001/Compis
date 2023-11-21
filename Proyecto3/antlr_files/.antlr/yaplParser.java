// Generated from c:/Users/charl/Desktop/S22023/Compiladores/Proyecto 3/C1/Compis/Proyecto3/antlr_files/yapl.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class yaplParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

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
	public static final int
		RULE_program = 0, RULE_classdef = 1, RULE_feature = 2, RULE_formal = 3, 
		RULE_expr = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "classdef", "feature", "formal", "expr"
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

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	 
		public ProgramContext() { }
		public void copyFrom(ProgramContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ProgramasContext extends ProgramContext {
		public TerminalNode EOF() { return getToken(yaplParser.EOF, 0); }
		public List<ClassdefContext> classdef() {
			return getRuleContexts(ClassdefContext.class);
		}
		public ClassdefContext classdef(int i) {
			return getRuleContext(ClassdefContext.class,i);
		}
		public ProgramasContext(ProgramContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).enterProgramas(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).exitProgramas(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			_localctx = new ProgramasContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(13); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(10);
				classdef();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassdefContext extends ParserRuleContext {
		public ClassdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classdef; }
	 
		public ClassdefContext() { }
		public void copyFrom(ClassdefContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ClaseContext extends ClassdefContext {
		public TerminalNode CLASS() { return getToken(yaplParser.CLASS, 0); }
		public List<TerminalNode> TYPE() { return getTokens(yaplParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(yaplParser.TYPE, i);
		}
		public TerminalNode INHERITS() { return getToken(yaplParser.INHERITS, 0); }
		public List<FeatureContext> feature() {
			return getRuleContexts(FeatureContext.class);
		}
		public FeatureContext feature(int i) {
			return getRuleContext(FeatureContext.class,i);
		}
		public ClaseContext(ClassdefContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).enterClase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).exitClase(this);
		}
	}

	public final ClassdefContext classdef() throws RecognitionException {
		ClassdefContext _localctx = new ClassdefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_classdef);
		int _la;
		try {
			_localctx = new ClaseContext(_localctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FeatureContext extends ParserRuleContext {
		public FeatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feature; }
	 
		public FeatureContext() { }
		public void copyFrom(FeatureContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PropiedadContext extends FeatureContext {
		public FormalContext formal() {
			return getRuleContext(FormalContext.class,0);
		}
		public TerminalNode ASSIGNMENT() { return getToken(yaplParser.ASSIGNMENT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PropiedadContext(FeatureContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).enterPropiedad(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).exitPropiedad(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MetodoContext extends FeatureContext {
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
		public MetodoContext(FeatureContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).enterMetodo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).exitMetodo(this);
		}
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
				_localctx = new MetodoContext(_localctx);
				enterOuterAlt(_localctx, 1);
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
				expr(0);
				setState(56);
				match(T__2);
				}
				break;
			case 2:
				_localctx = new PropiedadContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				formal();
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGNMENT) {
					{
					setState(59);
					match(ASSIGNMENT);
					setState(60);
					expr(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FormalContext extends ParserRuleContext {
		public FormalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formal; }
	 
		public FormalContext() { }
		public void copyFrom(FormalContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AsignacionContext extends FormalContext {
		public TerminalNode ID() { return getToken(yaplParser.ID, 0); }
		public TerminalNode TYPE() { return getToken(yaplParser.TYPE, 0); }
		public AsignacionContext(FormalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).enterAsignacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).exitAsignacion(this);
		}
	}

	public final FormalContext formal() throws RecognitionException {
		FormalContext _localctx = new FormalContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_formal);
		try {
			_localctx = new AsignacionContext(_localctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NewContext extends ExprContext {
		public TerminalNode NEW() { return getToken(yaplParser.NEW, 0); }
		public TerminalNode TYPE() { return getToken(yaplParser.TYPE, 0); }
		public NewContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).enterNew(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).exitNew(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenthesesContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParenthesesContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).enterParentheses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).exitParentheses(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LetInContext extends ExprContext {
		public TerminalNode LET() { return getToken(yaplParser.LET, 0); }
		public List<FormalContext> formal() {
			return getRuleContexts(FormalContext.class);
		}
		public FormalContext formal(int i) {
			return getRuleContext(FormalContext.class,i);
		}
		public TerminalNode IN() { return getToken(yaplParser.IN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> ASSIGNMENT() { return getTokens(yaplParser.ASSIGNMENT); }
		public TerminalNode ASSIGNMENT(int i) {
			return getToken(yaplParser.ASSIGNMENT, i);
		}
		public LetInContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).enterLetIn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).exitLetIn(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringContext extends ExprContext {
		public TerminalNode STRING() { return getToken(yaplParser.STRING, 0); }
		public StringContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).exitString(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Arithmetic1Context extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Arithmetic1Context(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).enterArithmetic1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).exitArithmetic1(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IsvoidContext extends ExprContext {
		public TerminalNode ISVOID() { return getToken(yaplParser.ISVOID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IsvoidContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).enterIsvoid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).exitIsvoid(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ExprContext {
		public TerminalNode ID() { return getToken(yaplParser.ID, 0); }
		public TerminalNode ASSIGNMENT() { return getToken(yaplParser.ASSIGNMENT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignmentContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).exitAssignment(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Arithmetic2Context extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Arithmetic2Context(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).enterArithmetic2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).exitArithmetic2(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileContext extends ExprContext {
		public TerminalNode WHILE() { return getToken(yaplParser.WHILE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LOOP() { return getToken(yaplParser.LOOP, 0); }
		public TerminalNode POOL() { return getToken(yaplParser.POOL, 0); }
		public WhileContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).enterWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).exitWhile(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntContext extends ExprContext {
		public TerminalNode INT() { return getToken(yaplParser.INT, 0); }
		public IntContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).enterInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).exitInt(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DispatchImplicitBContext extends ExprContext {
		public TerminalNode ID() { return getToken(yaplParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public DispatchImplicitBContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).enterDispatchImplicitB(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).exitDispatchImplicitB(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegativeContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NegativeContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).enterNegative(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).exitNegative(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolNotContext extends ExprContext {
		public TerminalNode NOT() { return getToken(yaplParser.NOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BoolNotContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).enterBoolNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).exitBoolNot(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BooleanContext extends ExprContext {
		public Token value;
		public TerminalNode TRUE() { return getToken(yaplParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(yaplParser.FALSE, 0); }
		public BooleanContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).enterBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).exitBoolean(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BlockContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).exitBlock(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComparissonContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ComparissonContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).enterComparisson(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).exitComparisson(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdContext extends ExprContext {
		public TerminalNode ID() { return getToken(yaplParser.ID, 0); }
		public IdContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).exitId(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfContext extends ExprContext {
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
		public IfContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).enterIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).exitIf(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DispatchExplicitAContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ID() { return getToken(yaplParser.ID, 0); }
		public TerminalNode TYPE() { return getToken(yaplParser.TYPE, 0); }
		public DispatchExplicitAContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).enterDispatchExplicitA(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof yaplListener ) ((yaplListener)listener).exitDispatchExplicitA(this);
		}
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
			setState(149);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				_localctx = new DispatchImplicitBContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(70);
				match(ID);
				setState(71);
				match(T__3);
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 12997418288148L) != 0)) {
					{
					{
					setState(72);
					expr(0);
					setState(77);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__4) {
						{
						{
						setState(73);
						match(T__4);
						setState(74);
						expr(0);
						}
						}
						setState(79);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					setState(84);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(85);
				match(T__5);
				}
				break;
			case 2:
				{
				_localctx = new IfContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(86);
				match(IF);
				setState(87);
				expr(0);
				setState(88);
				match(THEN);
				setState(89);
				expr(0);
				setState(90);
				match(ELSE);
				setState(91);
				expr(0);
				setState(92);
				match(FI);
				}
				break;
			case 3:
				{
				_localctx = new WhileContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(94);
				match(WHILE);
				setState(95);
				expr(0);
				setState(96);
				match(LOOP);
				setState(97);
				expr(0);
				setState(98);
				match(POOL);
				}
				break;
			case 4:
				{
				_localctx = new BlockContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(100);
				match(T__1);
				setState(104); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(101);
					expr(0);
					setState(102);
					match(T__0);
					}
					}
					setState(106); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 12997418288148L) != 0) );
				setState(108);
				match(T__2);
				}
				break;
			case 5:
				{
				_localctx = new NewContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(110);
				match(NEW);
				setState(111);
				match(TYPE);
				}
				break;
			case 6:
				{
				_localctx = new NegativeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(112);
				match(T__9);
				setState(113);
				expr(13);
				}
				break;
			case 7:
				{
				_localctx = new IsvoidContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(114);
				match(ISVOID);
				setState(115);
				expr(12);
				}
				break;
			case 8:
				{
				_localctx = new BoolNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(116);
				match(NOT);
				setState(117);
				expr(8);
				}
				break;
			case 9:
				{
				_localctx = new ParenthesesContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(118);
				match(T__3);
				setState(119);
				expr(0);
				setState(120);
				match(T__5);
				}
				break;
			case 10:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(122);
				match(ID);
				}
				break;
			case 11:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(123);
				match(INT);
				}
				break;
			case 12:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(124);
				match(STRING);
				}
				break;
			case 13:
				{
				_localctx = new BooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(125);
				((BooleanContext)_localctx).value = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==FALSE || _la==TRUE) ) {
					((BooleanContext)_localctx).value = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 14:
				{
				_localctx = new AssignmentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(126);
				match(ID);
				setState(127);
				match(ASSIGNMENT);
				setState(128);
				expr(2);
				}
				break;
			case 15:
				{
				_localctx = new LetInContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(129);
				match(LET);
				setState(130);
				formal();
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGNMENT) {
					{
					setState(131);
					match(ASSIGNMENT);
					setState(132);
					expr(0);
					}
				}

				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(135);
					match(T__4);
					setState(136);
					formal();
					setState(139);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ASSIGNMENT) {
						{
						setState(137);
						match(ASSIGNMENT);
						setState(138);
						expr(0);
						}
					}

					}
					}
					setState(145);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(146);
				match(IN);
				setState(147);
				expr(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(184);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(182);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new Arithmetic1Context(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(151);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(152);
						((Arithmetic1Context)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__10 || _la==T__11) ) {
							((Arithmetic1Context)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(153);
						expr(12);
						}
						break;
					case 2:
						{
						_localctx = new Arithmetic2Context(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(154);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(155);
						((Arithmetic2Context)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__12 || _la==T__13) ) {
							((Arithmetic2Context)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(156);
						expr(11);
						}
						break;
					case 3:
						{
						_localctx = new ComparissonContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(157);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(158);
						((ComparissonContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 229376L) != 0)) ) {
							((ComparissonContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(159);
						expr(10);
						}
						break;
					case 4:
						{
						_localctx = new DispatchExplicitAContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(160);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(163);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==T__7) {
							{
							setState(161);
							match(T__7);
							setState(162);
							match(TYPE);
							}
						}

						setState(165);
						match(T__8);
						setState(166);
						match(ID);
						setState(167);
						match(T__3);
						setState(178);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 12997418288148L) != 0)) {
							{
							{
							setState(168);
							expr(0);
							setState(173);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==T__4) {
								{
								{
								setState(169);
								match(T__4);
								setState(170);
								expr(0);
								}
								}
								setState(175);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
							}
							setState(180);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(181);
						match(T__5);
						}
						break;
					}
					} 
				}
				setState(186);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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
			return precpred(_ctx, 11);
		case 1:
			return precpred(_ctx, 10);
		case 2:
			return precpred(_ctx, 9);
		case 3:
			return precpred(_ctx, 19);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001-\u00bc\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0004\u0000\u000e\b\u0000\u000b\u0000\f"+
		"\u0000\u000f\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001\u0018\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0005\u0001\u001e\b\u0001\n\u0001\f\u0001!\t\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0005\u0002*\b\u0002\n\u0002\f\u0002-\t\u0002\u0005\u0002/\b\u0002"+
		"\n\u0002\f\u00022\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002>\b\u0002\u0003\u0002@\b\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0005\u0004L\b\u0004\n\u0004\f\u0004O\t\u0004\u0005"+
		"\u0004Q\b\u0004\n\u0004\f\u0004T\t\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0004\u0004i\b"+
		"\u0004\u000b\u0004\f\u0004j\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u0086\b\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u008c\b\u0004\u0005"+
		"\u0004\u008e\b\u0004\n\u0004\f\u0004\u0091\t\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0003\u0004\u0096\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u00a4\b\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004"+
		"\u00ac\b\u0004\n\u0004\f\u0004\u00af\t\u0004\u0005\u0004\u00b1\b\u0004"+
		"\n\u0004\f\u0004\u00b4\t\u0004\u0001\u0004\u0005\u0004\u00b7\b\u0004\n"+
		"\u0004\f\u0004\u00ba\t\u0004\u0001\u0004\u0000\u0001\b\u0005\u0000\u0002"+
		"\u0004\u0006\b\u0000\u0004\u0002\u0000\u0017\u0017\'\'\u0001\u0000\u000b"+
		"\f\u0001\u0000\r\u000e\u0001\u0000\u000f\u0011\u00d8\u0000\r\u0001\u0000"+
		"\u0000\u0000\u0002\u0013\u0001\u0000\u0000\u0000\u0004?\u0001\u0000\u0000"+
		"\u0000\u0006A\u0001\u0000\u0000\u0000\b\u0095\u0001\u0000\u0000\u0000"+
		"\n\u000b\u0003\u0002\u0001\u0000\u000b\f\u0005\u0001\u0000\u0000\f\u000e"+
		"\u0001\u0000\u0000\u0000\r\n\u0001\u0000\u0000\u0000\u000e\u000f\u0001"+
		"\u0000\u0000\u0000\u000f\r\u0001\u0000\u0000\u0000\u000f\u0010\u0001\u0000"+
		"\u0000\u0000\u0010\u0011\u0001\u0000\u0000\u0000\u0011\u0012\u0005\u0000"+
		"\u0000\u0001\u0012\u0001\u0001\u0000\u0000\u0000\u0013\u0014\u0005\u0015"+
		"\u0000\u0000\u0014\u0017\u0005*\u0000\u0000\u0015\u0016\u0005\u001b\u0000"+
		"\u0000\u0016\u0018\u0005*\u0000\u0000\u0017\u0015\u0001\u0000\u0000\u0000"+
		"\u0017\u0018\u0001\u0000\u0000\u0000\u0018\u0019\u0001\u0000\u0000\u0000"+
		"\u0019\u001f\u0005\u0002\u0000\u0000\u001a\u001b\u0003\u0004\u0002\u0000"+
		"\u001b\u001c\u0005\u0001\u0000\u0000\u001c\u001e\u0001\u0000\u0000\u0000"+
		"\u001d\u001a\u0001\u0000\u0000\u0000\u001e!\u0001\u0000\u0000\u0000\u001f"+
		"\u001d\u0001\u0000\u0000\u0000\u001f \u0001\u0000\u0000\u0000 \"\u0001"+
		"\u0000\u0000\u0000!\u001f\u0001\u0000\u0000\u0000\"#\u0005\u0003\u0000"+
		"\u0000#\u0003\u0001\u0000\u0000\u0000$%\u0005+\u0000\u0000%0\u0005\u0004"+
		"\u0000\u0000&+\u0003\u0006\u0003\u0000\'(\u0005\u0005\u0000\u0000(*\u0003"+
		"\u0006\u0003\u0000)\'\u0001\u0000\u0000\u0000*-\u0001\u0000\u0000\u0000"+
		"+)\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,/\u0001\u0000\u0000"+
		"\u0000-+\u0001\u0000\u0000\u0000.&\u0001\u0000\u0000\u0000/2\u0001\u0000"+
		"\u0000\u00000.\u0001\u0000\u0000\u000001\u0001\u0000\u0000\u000013\u0001"+
		"\u0000\u0000\u000020\u0001\u0000\u0000\u000034\u0005\u0006\u0000\u0000"+
		"45\u0005\u0007\u0000\u000056\u0005*\u0000\u000067\u0005\u0002\u0000\u0000"+
		"78\u0003\b\u0004\u000089\u0005\u0003\u0000\u00009@\u0001\u0000\u0000\u0000"+
		":=\u0003\u0006\u0003\u0000;<\u0005,\u0000\u0000<>\u0003\b\u0004\u0000"+
		"=;\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>@\u0001\u0000\u0000"+
		"\u0000?$\u0001\u0000\u0000\u0000?:\u0001\u0000\u0000\u0000@\u0005\u0001"+
		"\u0000\u0000\u0000AB\u0005+\u0000\u0000BC\u0005\u0007\u0000\u0000CD\u0005"+
		"*\u0000\u0000D\u0007\u0001\u0000\u0000\u0000EF\u0006\u0004\uffff\uffff"+
		"\u0000FG\u0005+\u0000\u0000GR\u0005\u0004\u0000\u0000HM\u0003\b\u0004"+
		"\u0000IJ\u0005\u0005\u0000\u0000JL\u0003\b\u0004\u0000KI\u0001\u0000\u0000"+
		"\u0000LO\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000MN\u0001\u0000"+
		"\u0000\u0000NQ\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000\u0000PH\u0001"+
		"\u0000\u0000\u0000QT\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000"+
		"RS\u0001\u0000\u0000\u0000SU\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000"+
		"\u0000U\u0096\u0005\u0006\u0000\u0000VW\u0005\u0019\u0000\u0000WX\u0003"+
		"\b\u0004\u0000XY\u0005 \u0000\u0000YZ\u0003\b\u0004\u0000Z[\u0005\u0016"+
		"\u0000\u0000[\\\u0003\b\u0004\u0000\\]\u0005\u0018\u0000\u0000]\u0096"+
		"\u0001\u0000\u0000\u0000^_\u0005!\u0000\u0000_`\u0003\b\u0004\u0000`a"+
		"\u0005\u001e\u0000\u0000ab\u0003\b\u0004\u0000bc\u0005\u001f\u0000\u0000"+
		"c\u0096\u0001\u0000\u0000\u0000dh\u0005\u0002\u0000\u0000ef\u0003\b\u0004"+
		"\u0000fg\u0005\u0001\u0000\u0000gi\u0001\u0000\u0000\u0000he\u0001\u0000"+
		"\u0000\u0000ij\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000jk\u0001"+
		"\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000lm\u0005\u0003\u0000\u0000"+
		"m\u0096\u0001\u0000\u0000\u0000no\u0005$\u0000\u0000o\u0096\u0005*\u0000"+
		"\u0000pq\u0005\n\u0000\u0000q\u0096\u0003\b\u0004\rrs\u0005\u001c\u0000"+
		"\u0000s\u0096\u0003\b\u0004\ftu\u0005&\u0000\u0000u\u0096\u0003\b\u0004"+
		"\bvw\u0005\u0004\u0000\u0000wx\u0003\b\u0004\u0000xy\u0005\u0006\u0000"+
		"\u0000y\u0096\u0001\u0000\u0000\u0000z\u0096\u0005+\u0000\u0000{\u0096"+
		"\u0005)\u0000\u0000|\u0096\u0005(\u0000\u0000}\u0096\u0007\u0000\u0000"+
		"\u0000~\u007f\u0005+\u0000\u0000\u007f\u0080\u0005,\u0000\u0000\u0080"+
		"\u0096\u0003\b\u0004\u0002\u0081\u0082\u0005\u001d\u0000\u0000\u0082\u0085"+
		"\u0003\u0006\u0003\u0000\u0083\u0084\u0005,\u0000\u0000\u0084\u0086\u0003"+
		"\b\u0004\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000"+
		"\u0000\u0000\u0086\u008f\u0001\u0000\u0000\u0000\u0087\u0088\u0005\u0005"+
		"\u0000\u0000\u0088\u008b\u0003\u0006\u0003\u0000\u0089\u008a\u0005,\u0000"+
		"\u0000\u008a\u008c\u0003\b\u0004\u0000\u008b\u0089\u0001\u0000\u0000\u0000"+
		"\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u008e\u0001\u0000\u0000\u0000"+
		"\u008d\u0087\u0001\u0000\u0000\u0000\u008e\u0091\u0001\u0000\u0000\u0000"+
		"\u008f\u008d\u0001\u0000\u0000\u0000\u008f\u0090\u0001\u0000\u0000\u0000"+
		"\u0090\u0092\u0001\u0000\u0000\u0000\u0091\u008f\u0001\u0000\u0000\u0000"+
		"\u0092\u0093\u0005\u001a\u0000\u0000\u0093\u0094\u0003\b\u0004\u0001\u0094"+
		"\u0096\u0001\u0000\u0000\u0000\u0095E\u0001\u0000\u0000\u0000\u0095V\u0001"+
		"\u0000\u0000\u0000\u0095^\u0001\u0000\u0000\u0000\u0095d\u0001\u0000\u0000"+
		"\u0000\u0095n\u0001\u0000\u0000\u0000\u0095p\u0001\u0000\u0000\u0000\u0095"+
		"r\u0001\u0000\u0000\u0000\u0095t\u0001\u0000\u0000\u0000\u0095v\u0001"+
		"\u0000\u0000\u0000\u0095z\u0001\u0000\u0000\u0000\u0095{\u0001\u0000\u0000"+
		"\u0000\u0095|\u0001\u0000\u0000\u0000\u0095}\u0001\u0000\u0000\u0000\u0095"+
		"~\u0001\u0000\u0000\u0000\u0095\u0081\u0001\u0000\u0000\u0000\u0096\u00b8"+
		"\u0001\u0000\u0000\u0000\u0097\u0098\n\u000b\u0000\u0000\u0098\u0099\u0007"+
		"\u0001\u0000\u0000\u0099\u00b7\u0003\b\u0004\f\u009a\u009b\n\n\u0000\u0000"+
		"\u009b\u009c\u0007\u0002\u0000\u0000\u009c\u00b7\u0003\b\u0004\u000b\u009d"+
		"\u009e\n\t\u0000\u0000\u009e\u009f\u0007\u0003\u0000\u0000\u009f\u00b7"+
		"\u0003\b\u0004\n\u00a0\u00a3\n\u0013\u0000\u0000\u00a1\u00a2\u0005\b\u0000"+
		"\u0000\u00a2\u00a4\u0005*\u0000\u0000\u00a3\u00a1\u0001\u0000\u0000\u0000"+
		"\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000"+
		"\u00a5\u00a6\u0005\t\u0000\u0000\u00a6\u00a7\u0005+\u0000\u0000\u00a7"+
		"\u00b2\u0005\u0004\u0000\u0000\u00a8\u00ad\u0003\b\u0004\u0000\u00a9\u00aa"+
		"\u0005\u0005\u0000\u0000\u00aa\u00ac\u0003\b\u0004\u0000\u00ab\u00a9\u0001"+
		"\u0000\u0000\u0000\u00ac\u00af\u0001\u0000\u0000\u0000\u00ad\u00ab\u0001"+
		"\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000\u00ae\u00b1\u0001"+
		"\u0000\u0000\u0000\u00af\u00ad\u0001\u0000\u0000\u0000\u00b0\u00a8\u0001"+
		"\u0000\u0000\u0000\u00b1\u00b4\u0001\u0000\u0000\u0000\u00b2\u00b0\u0001"+
		"\u0000\u0000\u0000\u00b2\u00b3\u0001\u0000\u0000\u0000\u00b3\u00b5\u0001"+
		"\u0000\u0000\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000\u00b5\u00b7\u0005"+
		"\u0006\u0000\u0000\u00b6\u0097\u0001\u0000\u0000\u0000\u00b6\u009a\u0001"+
		"\u0000\u0000\u0000\u00b6\u009d\u0001\u0000\u0000\u0000\u00b6\u00a0\u0001"+
		"\u0000\u0000\u0000\u00b7\u00ba\u0001\u0000\u0000\u0000\u00b8\u00b6\u0001"+
		"\u0000\u0000\u0000\u00b8\u00b9\u0001\u0000\u0000\u0000\u00b9\t\u0001\u0000"+
		"\u0000\u0000\u00ba\u00b8\u0001\u0000\u0000\u0000\u0013\u000f\u0017\u001f"+
		"+0=?MRj\u0085\u008b\u008f\u0095\u00a3\u00ad\u00b2\u00b6\u00b8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}