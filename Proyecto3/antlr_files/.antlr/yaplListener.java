// Generated from c:/Users/charl/Desktop/FINAL/Compis-version3/Compis-version3/antlr_files/yapl.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link yaplParser}.
 */
public interface yaplListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code programas}
	 * labeled alternative in {@link yaplParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgramas(yaplParser.ProgramasContext ctx);
	/**
	 * Exit a parse tree produced by the {@code programas}
	 * labeled alternative in {@link yaplParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgramas(yaplParser.ProgramasContext ctx);
	/**
	 * Enter a parse tree produced by the {@code clase}
	 * labeled alternative in {@link yaplParser#classdef}.
	 * @param ctx the parse tree
	 */
	void enterClase(yaplParser.ClaseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code clase}
	 * labeled alternative in {@link yaplParser#classdef}.
	 * @param ctx the parse tree
	 */
	void exitClase(yaplParser.ClaseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code metodo}
	 * labeled alternative in {@link yaplParser#feature}.
	 * @param ctx the parse tree
	 */
	void enterMetodo(yaplParser.MetodoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code metodo}
	 * labeled alternative in {@link yaplParser#feature}.
	 * @param ctx the parse tree
	 */
	void exitMetodo(yaplParser.MetodoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code propiedad}
	 * labeled alternative in {@link yaplParser#feature}.
	 * @param ctx the parse tree
	 */
	void enterPropiedad(yaplParser.PropiedadContext ctx);
	/**
	 * Exit a parse tree produced by the {@code propiedad}
	 * labeled alternative in {@link yaplParser#feature}.
	 * @param ctx the parse tree
	 */
	void exitPropiedad(yaplParser.PropiedadContext ctx);
	/**
	 * Enter a parse tree produced by the {@code asignacion}
	 * labeled alternative in {@link yaplParser#formal}.
	 * @param ctx the parse tree
	 */
	void enterAsignacion(yaplParser.AsignacionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code asignacion}
	 * labeled alternative in {@link yaplParser#formal}.
	 * @param ctx the parse tree
	 */
	void exitAsignacion(yaplParser.AsignacionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code new}
	 * labeled alternative in {@link yaplParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNew(yaplParser.NewContext ctx);
	/**
	 * Exit a parse tree produced by the {@code new}
	 * labeled alternative in {@link yaplParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNew(yaplParser.NewContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parentheses}
	 * labeled alternative in {@link yaplParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParentheses(yaplParser.ParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parentheses}
	 * labeled alternative in {@link yaplParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParentheses(yaplParser.ParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code letIn}
	 * labeled alternative in {@link yaplParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLetIn(yaplParser.LetInContext ctx);
	/**
	 * Exit a parse tree produced by the {@code letIn}
	 * labeled alternative in {@link yaplParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLetIn(yaplParser.LetInContext ctx);
	/**
	 * Enter a parse tree produced by the {@code string}
	 * labeled alternative in {@link yaplParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterString(yaplParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code string}
	 * labeled alternative in {@link yaplParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitString(yaplParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arithmetic1}
	 * labeled alternative in {@link yaplParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmetic1(yaplParser.Arithmetic1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code arithmetic1}
	 * labeled alternative in {@link yaplParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmetic1(yaplParser.Arithmetic1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code isvoid}
	 * labeled alternative in {@link yaplParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIsvoid(yaplParser.IsvoidContext ctx);
	/**
	 * Exit a parse tree produced by the {@code isvoid}
	 * labeled alternative in {@link yaplParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIsvoid(yaplParser.IsvoidContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignment}
	 * labeled alternative in {@link yaplParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(yaplParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignment}
	 * labeled alternative in {@link yaplParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(yaplParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arithmetic2}
	 * labeled alternative in {@link yaplParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmetic2(yaplParser.Arithmetic2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code arithmetic2}
	 * labeled alternative in {@link yaplParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmetic2(yaplParser.Arithmetic2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code while}
	 * labeled alternative in {@link yaplParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterWhile(yaplParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code while}
	 * labeled alternative in {@link yaplParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitWhile(yaplParser.WhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code int}
	 * labeled alternative in {@link yaplParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInt(yaplParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int}
	 * labeled alternative in {@link yaplParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInt(yaplParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dispatchImplicitB}
	 * labeled alternative in {@link yaplParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDispatchImplicitB(yaplParser.DispatchImplicitBContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dispatchImplicitB}
	 * labeled alternative in {@link yaplParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDispatchImplicitB(yaplParser.DispatchImplicitBContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negative}
	 * labeled alternative in {@link yaplParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNegative(yaplParser.NegativeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negative}
	 * labeled alternative in {@link yaplParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNegative(yaplParser.NegativeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolNot}
	 * labeled alternative in {@link yaplParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBoolNot(yaplParser.BoolNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolNot}
	 * labeled alternative in {@link yaplParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBoolNot(yaplParser.BoolNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolean}
	 * labeled alternative in {@link yaplParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBoolean(yaplParser.BooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolean}
	 * labeled alternative in {@link yaplParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBoolean(yaplParser.BooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code block}
	 * labeled alternative in {@link yaplParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBlock(yaplParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code block}
	 * labeled alternative in {@link yaplParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBlock(yaplParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparisson}
	 * labeled alternative in {@link yaplParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterComparisson(yaplParser.ComparissonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparisson}
	 * labeled alternative in {@link yaplParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitComparisson(yaplParser.ComparissonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link yaplParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterId(yaplParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link yaplParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitId(yaplParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code if}
	 * labeled alternative in {@link yaplParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIf(yaplParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code if}
	 * labeled alternative in {@link yaplParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIf(yaplParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dispatchExplicitA}
	 * labeled alternative in {@link yaplParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDispatchExplicitA(yaplParser.DispatchExplicitAContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dispatchExplicitA}
	 * labeled alternative in {@link yaplParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDispatchExplicitA(yaplParser.DispatchExplicitAContext ctx);
}