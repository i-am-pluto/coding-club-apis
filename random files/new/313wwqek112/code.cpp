#include <iostream>
using namespace std;

void merge(int arr[], int start, int end, int mid)
{
	int j = mid - start + 1;
	int k = end - mid;
	int arr1[j];
	int arr2[k];
	int starting = start;
	for (int i = 0; i < j; i++)
	{
		arr1[i] = arr[start + i];
	}
	for (int z = 0; z < k; z++)
	{
		arr2[z] = arr[mid + 1 + z];
	}
	int a = 0;
	int b = 0;

	while (a < j && b < k)
	{
		if (arr1[a] > arr2[b])
		{
			arr[starting] = arr2[b];
			b++;
		}
		else
		{
			arr[starting] = arr1[a];
			a++;
		}
		starting++;
	}
	while (a < j)
	{
		arr[starting] = arr1[a];
		a++;
		starting++;
	}
	while (b < k)
	{
		arr[starting] = arr2[b];
		b++;
		starting++;
	}
}

void mergesort(int arr[], int start, int end)
{
	if (start < end)
	{

		int mid = start + (end - start) / 2;
		mergesort(arr, start, mid);
		mergesort(arr, mid + 1, end);
		merge(arr, start, end, mid);
	}
}

int main()
{
	cout << "The intial array is" << endl;
	int arr[] = {-89, -562, 785, 10, 23, 45, 69, 78, 96, 2354, 456};
	for (int i = 0; i < sizeof(arr) / sizeof(arr[0]); i++)
	{
		cout << "The value of arr at" << i << "index " << arr[i] << endl;
	}

	mergesort(arr, 0, 10);
	cout << endl;
	cout << endl;
	cout << "The array after sorting" << endl;
	for (int j = 0; j < 11; j++)
	{
		cout << "The value of arr at " << j << " "
			 << " index " << arr[j] << endl;
	}
	return 0;
}
