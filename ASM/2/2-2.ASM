;设W、X、Y、Z均为16位字单元有符号数，编程计算W=(X*Y-50)/Z,将结果存入变量W,而余数存入变量W+2中。（X为非零数，并假设X、Y、Z的值分别为50、20、10、15）

DATA 	SEGMENT
W 	DB	?
X 	DB 	50H
Y 	DB 	20H
Z 	DB 	10H
DATA ENDS
CODE	SEGMENT
	ASSUME	CS:CODE,DS:DATA
START:
	MOV		AX,		DATA
	MOV		DS,		AX

	MOV		AL,		X
	MUL		 Y
	SUB		AL, 	50H
	DIV		 Z
	MOV		 W,		AL
	MOV	 [W+2],		AH

	MOV	AX,	4CH
	INT	21H
CODE   	ENDS
        END  START