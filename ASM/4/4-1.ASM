CODE  SEGMENT
	ASSUME   CS:CODE
START:
NI:					;NEXT INPUT
	MOV   AH,   1
	INT   21H
	CMP	  AL,   '#'	; Jump out the loop
	JE	  EI

	CMP	  AL,   'A' 
	JL	  NI 		; Goto NI

	CMP	  AL,   'Z'
	JG	  LOWER
	ADD   AL,	20H
	JMP   PRINT

LOWER:
	CMP   AL,   'a'
	JL    NI

	CMP   AL,   'z'
	JA    NI

	SUB   AL,   20H
	JMP   PRINT

PRINT:
   MOV   AH,   02H
   MOV   DL,   AL
   INT   21H
   JMP   NI

EI:					;END INPUT
   MOV   AH,   4CH
   INT   21H
CODE  ENDS
   END   START
