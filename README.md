# eBNF
```
PROGRAM = { WHITESPACE } FUNCTIONS .
FUNCTIONS = FUNCTION { WHITESPACE } { FUNCTION { WHITESPACE } } .
FUNCTION = RETURN_TYPE
           { WHITESPACE } NAME
           { WHITESPACE } '('
           { WHITESPACE } [ ARGUMENTS ] ')'
           { WHITESPACE } BLOCK .
ARGUMENTS = ARGUMENT { WHITESPACE } { ',' { WHITESPACE } ARGUMENT { WHITESPACE } } .
RETURN_TYPE = 'void' | TYPE .
ARGUMENT = TYPE { WHITESPACE } NAME .
BLOCK = '{' { WHITESPACE } { STATEMENT { WHITESPACE } } '}' .
STATEMENT = VAR_DEFINITION | ASSIGNMENT | IF | WHILE | LOOP_OP | CALL | RETURN .
VAR_DEFINITION = TYPE
                 { WHITESPACE } NAME
                 { WHITESPACE } '='
                 { WHITESPACE } EXPRESSION .
ASSIGNMENT = VAR_ACCESS { WHITESPACE } '=' { WHITESPACE } EXPRESSION .
IF = 'if'
     { WHITESPACE } BRACKETS_EXPR
     { WHITESPACE } BLOCK
     { WHITESPACE } [ 'else' { WHITESPACE } BLOCK ] .
WHILE = 'while'
        { WHITESPACE } BRACKETS_EXPR
        { WHITESPACE } BLOCK .
LOOP_OP = 'break' | 'continue' .
CALL = NAME { WHITESPACE } '(' { WHITESPACE } [ EXPRESSIONS ] ')' .
EXPRESSIONS = EXPRESSION { WHITESPACE }
              { ',' { WHITESPACE } EXPRESSION { WHITESPACE } } .
RETURN = 'return' { WHITESPACE } EXPRESSION .
EXPRESSION = AND_EXPR { WHITESPACE } { '||' { WHITESPACE } AND_EXPR { WHITESPACE } } .
AND_EXPR = EQUAL_EXPR { WHITESPACE } { '&&' { WHITESPACE } EQUAL_EXPR { WHITESPACE } } .
EQUAL_EXPR = REL_EXPR { WHITESPACE } [ ( '==' | '!=' ) { WHITESPACE } REL_EXPR ] .
REL_EXPR = ADD_EXPR { WHITESPACE } [ ( '<' | '>' | '<=' | '>=' ) { WHITESPACE } ADD_EXPR ] .
ADD_EXPR = MUL_EXPR { WHITESPACE } { ('+' | '-') { WHITESPACE } MUL_EXPR } .
MUL_EXPR = UNARY_EXPR { WHITESPACE } { ('*' | '/' | '%') { WHITESPACE } UNARY_EXPR { WHITESPACE } } .
UNARY_EXPR = [ '!' | '-' ] { WHITESPACE } VAL_EXPR .
VAL_EXPR = BRACKETS_EXPR | CONST | CALL | VAR_ACCESS | NEW_ARRAY .
BRACKETS_EXPR = '(' { WHITESPACE } EXPRESSION ')' .
NEW_ARRAY = BASIC_TYPE { WHITESPACE } INDEX_EXPR .
VAR_ACCESS = NAME { WHITESPACE } [ INDEX_EXPR ] .
INDEX_EXPR = '[' { WHITESPACE } EXPRESSION ']' .
TYPE = BASIC_TYPE [ '[]' ] .
BASIC_TYPE = 'int' | 'float' | 'boolean' | 'string' .
NAME = CHAR { ALPHA_NUM } .
ALPHA_NUM = CHAR | DIGIT .
CHAR = '_' | ? unicode letter ? .
DIGIT = '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9' .
CONST = NUMBER | STRING | BOOLEAN .
NUMBER = INT_PART [ '.' INT_PART ] .
INT_PART = DIGIT { DIGIT } .
STRING = '"' { STR_CHAR } '"' .
STR_CHAR = ESC_CHAR | ANY_CHAR .
ESC_CHAR = '\"' | '\n' .
ANY_CHAR = ? any unicode symbol ? .
BOOLEAN = 'true' | 'false' .
```

# Types
```
Name        Java analog    Pass by
void        void           -
int         long           value
float       double         value
boolean     boolean        value
string      String         reference
int[]       long[]         reference
float[]     double[]       reference
boolean[]   boolean[]      reference
string[]    String[]       reference
```

# Example
```
void main()
{
    int arrSize = getArraySize()
    int[] array = int[arraySize]

    fillRandom(array)

    println("Random generated array:")
    printArray(array)

    quickSort(array)

    println("Sorted array:")
    printArray(array)
}

int getArraySize()
{
    int arrSize = 0

    while (true)
    {
        println("Please enter the array size:")
        arrSize = readInt()
        if (isOk())
        {
            if (arrSize <= 0)
            {
                println("Array size must be greater than zero! You entered: " + arrSize)
            }
            else
            {
                return arrSize
            }
        }
        else
        {
            println("Unrecognized value")
        }
    }
}

void fillRandom(int[] arr)
{
    int i = 0

    while (i < size(arr))
    {
        arr[i] = random(100)
        i = i + 1
    }
}

void printArray(int[] arr)
{
    int i = 0

    while (i < size(arr))
    {
        print(arr[i] + " ")
        i = i + 1
    }
    println()
}

void quickSort(int[] arr)
{
    qsort(arr, 0, size(arr) - 1)
}

void qsort(int[] arr, int i, int j)
{
    int l = i
    int r = j
    int piv = arr[(r + l) / 2]

    while (l <= r)
    {
        while (arr[l] < piv)
        {
            l = l + 1
        }
        while (arr[r] > piv)
        {
            r = r - 1
        }
        if (l <= r)
        {
            int temp = arr[l]
            arr[l] = arr[r]
            arr[r] = temp
            l = l + 1
            r = r - 1
        }
    }
    if (i > r)
    {
        qsort(arr, i, r)
    }
    if (j > l)
    {
        qsort(arr, l, j)
    }
}
```

# Standard library
```
    println()
    println(string)
    print(string)
    size(int[])
    size(float[])
    size(boolean[])
    size(string[])
    random(int)
    int readInt()
    boolean isOk() true, if last readInt() was successfull, false otherwise
```