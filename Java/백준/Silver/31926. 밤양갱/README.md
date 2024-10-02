# [Silver I] 밤양갱 - 31926 

[문제 링크](https://www.acmicpc.net/problem/31926) 

### 성능 요약

메모리: 14416 KB, 시간: 524 ms

### 분류

애드 혹, 그리디 알고리즘, 수학

### 제출 일자

2024년 10월 3일 02:37:45

### 문제 설명

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/2ebd27e9-0760-45bc-bc23-2cda874469a8/-/preview/" style="height: 366px; width: 400px;"></p>

<blockquote>
<p>달디달고, 달디달고, 달디단, 밤양갱, 밤양갱</p>

<p><장기하, 밤양갱, 2024></p>
</blockquote>

<p>민우는 비비의 신곡 <밤양갱>에 꽂혀 하루 종일 "달디달고 달디달고 달디달고... 달디단"이 머릿속을 맴돌고 있다. </p>

<p>민우의 머릿속에선 <code><span style="color:#e74c3c;">daldidalgo</span></code>가 총 $N$번 반복된 후, 반복이 완료되었다면 <code><span style="color:#e74c3c;">daldidan</span></code>으로 끝나게 된다. 예를 들어 $N=3$이라면 민우의 머릿속엔 <code><span style="color:#e74c3c;">daldidalgo</span><span style="color:#2980b9;">daldidalgo</span><span style="color:#16a085;">daldidalgo</span><span style="color:#e74c3c;">daldidan</span></code>이 재생된다.</p>

<p>민우는 $N$이 주어지면 얼마나 빨리 <code><span style="color:#e74c3c;">daldidalgodaldidalgo...daldidan</span></code>을 컴퓨터에 입력할 수 있는지 궁금하다. 매초 민우는 두 개의 작업 중 하나를 선택하여 시행할 수 있다.</p>

<ul>
	<li>알파벳 소문자 <code><span style="color:#e74c3c;">a</span></code>부터 <code><span style="color:#e74c3c;">z </span></code>중에서 민우가 원하는 알파벳을 하나 골라서 지금까지 입력한 내용의 맨 뒤에 입력한다.</li>
	<li>지금까지 입력한 문자열의 연속된 부분 문자열을 복사 후 입력한 내용의 맨 뒤에 붙여넣는다. 예를 들어 지금까지 작성한 문자열이 <code><span style="color:#e74c3c;">ajouapcshake</span></code>라면, <code><span style="color:#e74c3c;">ajouapcshake</span></code>를 복사할 수도, <code><span style="color:#e74c3c;">apc</span></code>를 복사할 수도 있지만, <code><span style="color:#e74c3c;">aashake</span></code>를 복사하여 붙여넣을 수는 없다.</li>
</ul>

<p>민우는 몇 초 만에 머릿속에 떠오른 가사를 컴퓨터에 입력할 수 있을까?</p>

### 입력 

 <p>첫 번째 줄에 민우의 머릿속에 떠오른 <code><span style="color:#e74c3c;">daldidalgo</span></code>의 횟수 $N$이 주어진다. $(1\leq N \leq 10^9)$</p>

### 출력 

 <p>민우가 문제에 언급된 시행 중 하나를 선택하여 매초 시행했을 때, $N$번의 <code><span style="color:#e74c3c;">daldidalgo</span></code>를 입력한 후 $1$번의 <code><span style="color:#e74c3c;">daldidan</span></code>을 입력할 수 있는 최소 시간을 출력한다.</p>

