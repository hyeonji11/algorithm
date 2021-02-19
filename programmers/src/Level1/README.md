## 1. 크레인 인형뽑기 게임(ClawMachineGame.java)

Stack을 이용해 바구니에 인형을 넣고, 터트리는 행위를 구현했다.

```
if(board[i][value-1] != 0) {
  if(!stack.isEmpty()) {
    if(stack.peek() == board[i][value-1]) {
      stack.pop();
      board[i][value-1] = 0;
      answer++;
      break;
    }
  }
  stack.push(board[i][value-1]);
  board[i][value-1] = 0;
  break;
}
```

answer에는 터지는 횟수를 저장하고 리턴할 때 2는 곱해서 리턴했다.
터지는 횟수 대신 answer += 2; 로 저장해서 리턴하는 방법도 있다.
