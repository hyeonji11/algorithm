## 1. 효율적인 해킹(EfficientHacking.java)

이 문제는 풀이과정 자체는 어렵지 않았지만 시간초과때문에 많이 틀렸다.

풀이 과정은
1) 컴퓨터간 연관 관계 저장
2) 컴퓨터들 탐색하며 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터 찾기
이렇게 나눌 수 있다.

1번은 처음엔 B를 인덱스로 놓고 B가 해킹할 수 있는 컴퓨터인 A를 리스트에 넣어서 저장했는데 나중에 비교해보니 시간초과가 나는 원인중에 하나가 이 방법이였다. 그래서 A를 인덱스로 하고 A를 해킹할 수 있는 컴퓨터인 B를 리스트에 넣어서 저장하는 방식으로 구현했다.
```
for(int i=0; i<num; i++) {
  st = new StringTokenizer(br.readLine());
  int a = Integer.parseInt(st.nextToken());
  int b = Integer.parseInt(st.nextToken());
  list[a].add(b);
}
```
둘의 시간 차이는 히든 테스트케이스 중 같은 B가 해킹할 수 있는 컴퓨터가 굉장히 많이 있는 케이스가 존재해서 시간초과가 났을 것으로 추측해본다.

2번은 좀 더 단계를 나눠서 생각하면 컴퓨터 탐색과 많은 컴퓨터를 해킹할 수 있는 컴퓨터 찾기로 나눌 수 있다.
컴퓨터 탐색은 visited 배열과 depth배열을 이용했다.
컴퓨터 번호를 매개변수로 dfs 메소드를 호출할 수 있도록 하고 그 매개변수를 해킹할 수 있는 컴퓨터들도 dfs 메소드를 호출하도록 구현했다. 방문하지 않은 컴퓨터에 대해서 dfs를 호출할 때 그 컴퓨터 번호 인덱스의 depth 배열에 1씩 더해줌으로써 탐색을 모두 마쳤을 때 제일 많은 컴퓨터를 해킹할 수 있는 컴퓨터는 depth에서 가장 최대값을 가진 인덱스가 된다.
```
public static void dfs(int start) {
  visited[start] = true;
  for(int num: list[start]) {
    if(!visited[num]) {
      depth[num]++;
      dfs(num);
    }
  }
}
```
많은 컴퓨터를 해킹할 수 있는 컴퓨터를 찾는 것은 먼저 depth의 최대값을 찾고 그 값을 가진 인덱스들을 찾아서 출력했다.