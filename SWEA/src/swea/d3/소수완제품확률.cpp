#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <math.h>

#define MAX_PRODUCT 18
#define NUM_OF_PRIMES 7
int main() {
	int TC;
	scanf("%d", &TC);

	// 1. 파스칼의 삼각형으로 소수인 경우의 수 미리 구하기
	int combination[MAX_PRODUCT + 1][MAX_PRODUCT + 1] = { 0, };
	combination[0][0] = 1;
	for (int i = 1; i <= MAX_PRODUCT; i++) {
		combination[i][0] = 1;
		for (int j = 1; j <= MAX_PRODUCT; j++) {
			combination[i][j] = combination[i - 1][j - 1] + combination[i - 1][j];
		}
	}

	// 2. 18 아래의 소수들. 각각 소수가 나올 확률을 다 더해주면 정답이다.
	int primes[NUM_OF_PRIMES] = {2, 3, 5, 7, 11, 13, 17};

	for (int testCase = 1; testCase <= TC; testCase++) {
		double a = 0, b = 0;
		scanf(" %lf %lf", &a, &b);

		a /= 100;
		b /= 100;
		double answer = 0;

		// 3. 모든 소수의 확률을 다 더해준다.
		// 완제품 2개를 만들 확률 = 18개 중에서 2개를 고르는 경우의 수 X 0.8 X 0.8(성공확률 2번) X 0.2 .. X 0.2(실패확률 16번, 실패확률은 1 - 성공확률)
		// = 18C2 X 0.8^2 X 0.2^16
		double pa = 0, pb = 0;
		for (int p = 0; p < NUM_OF_PRIMES; p++) {
			pa += (double)combination[MAX_PRODUCT][primes[p]] * pow(a, primes[p]) * pow(1 - a, MAX_PRODUCT - primes[p]);
			// 18C2나 18C16이나 같아서 MAX_PRODUCT - primes[p]처럼 불필요한 뺄셈 연산을 할 필요 X
			pb += (double)combination[MAX_PRODUCT][primes[p]] * pow(b, primes[p]) * pow(1 - b, MAX_PRODUCT - primes[p]);
		}

		// 4. 정답을 구한다.
		answer = 1 - ((1 - pa) * (1 - pb));

		printf("#%d %.6lf\n", testCase, answer);
	}

	return 0;
}