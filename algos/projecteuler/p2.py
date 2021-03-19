fib = [0, 1]

while fib[-1] < (4*(10**6)):
  fib.append(fib[-1] + fib[-2])

ret = 0
for f in fib:
  if not f % 2:
    ret += f

print(ret)
