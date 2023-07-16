grammar yapl;

INT        : [0-9]+;
ID         : [a-zA-Z_][a-zA-Z0-9_]*;
TYPE_ID    : [A-Z][a-zA-Z0-9_]*;
OBJECT_ID  : [a-z][a-zA-Z0-9_]*;
STRING     : '"' (~[\b\t\n\f\\] | '\\' [btnf])* '"';

WS         : [ \t\r\n\f]+ -> skip;

CLASS     : [Cc][Ll][Aa][Ss][Ss];
ELSE      : [Ee][Ll][Ss][Ee];
ESAC      : [Ee][Ss][Aa][Cc];
FALSE     : [Ff][Aa][Ll][Ss][Ee];
FI        : [Ff][Ii];
IF        : [Ii][Ff];
IN        : [Ii][Nn];
INHERITS  : [Ii][Nn][Hh][Ee][Rr][Ii][Tt][Ss];
ISVOID    : [Ii][Ss][Vv][Oo][Ii][Dd];
LET       : [Ll][Ee][Tt];
LOOP      : [Ll][Oo][Oo][Pp];
NEW       : [Nn][Ee][Ww];
NOT       : [Nn][Oo][Tt];
OF        : [Oo][Ff];
POOL      : [Pp][Oo][Oo][Ll];
THEN      : [Tt][Hh][Ee][Nn];
TRUE      : [Tt][Rr][Uu][Ee];
WHILE     : [Ww][Hh][Ii][Ll][Ee];
CASE      : [Cc][Aa][Ss][Ee];


program      : class_list EOF;
class_list   : class_def+;
class_def    : CLASS TYPE_ID (INHERITS TYPE_ID)? '{' feature_list '}';
feature_body : '=' expr
             | '(' formal_list ')' ':' TYPE_ID '{' expr_list '}'
             | '{' expr_list '}';
feature_def  : OBJECT_ID ':' TYPE_ID (feature_body)? ';';
feature_list : feature_def*;
formal_list  : formal_param (',' formal_param)*;
formal_param : OBJECT_ID ':' TYPE_ID;
expr_list    : expr (';' expr)*;


expr : IF expr THEN expr ELSE expr FI
     | WHILE expr LOOP expr POOL
     | '{' expr_list '}'
     | LET OBJECT_ID ':' TYPE_ID ('<-' expr)? (',' OBJECT_ID ':' TYPE_ID ('<-' expr)?)* IN expr
     | CASE expr OF case_list ESAC
     | NEW TYPE_ID
     | ISVOID expr
     | expr '.' OBJECT_ID '(' expr_list ')'
     | expr '@' TYPE_ID '.' OBJECT_ID '(' expr_list ')'
     | expr '~'
     | NOT expr
     | expr '*' expr
     | expr '/' expr
     | expr '+' expr
     | expr '-' expr
     | expr '<=' expr
     | expr '<' expr
     | expr '=' expr
     | expr ISVOID
     | '(' expr ')'
     | OBJECT_ID
     | INT
     | TRUE
     | FALSE
     | STRING;

case_list : case_def+;

case_def : OBJECT_ID ':' TYPE_ID '=>' expr ';';


fragment LETTER : [a-zA-Z];
fragment DIGIT : [0-9];