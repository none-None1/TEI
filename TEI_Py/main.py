import sys
if len(sys.argv)==1:
    code=sys.stdin.read()
else:
    code=open(sys.argv[1]).read()
stack=[]
for i in code:
    if i=='+':
        a,b=stack.pop(),stack.pop()
        stack.append(b+a)
    if i=='-':
        a,b=stack.pop(),stack.pop()
        stack.append(b-a)
    if i=='*':
        a,b=stack.pop(),stack.pop()
        stack.append(b*a)
    if i=='?':
        c=sys.stdin.read()
        stack.append(ord(c) if c else -1)
    if i==',':
        stack.append(int(input()))
    if i=='.':
        print(stack.pop(),end=' ')
    if i=='!':
        print(chr(stack.pop()),end='')
    if i in '1234567890':
        stack.append(int(i))
    if i not in '+-*?,.!1234567890':
        stack.append(ord(i))