class Solution {
public
 
double
 
findMedianSortedArrays
(
int
[
]
 nums1
,
 
int
[
]
 nums2
)
 
{

    
// Ensure nums1 is the shorter array for optimization

    
if
 
(
nums1
.
length 
>
 nums2
.
length
)
 
{

        
return
 
findMedianSortedArrays
(
nums2
,
 nums1
)
;
 
// Swap arrays so nums1 is smaller

    
}

    
int
 x 
=
 nums1
.
length
;
 
// Length of smaller array

    
int
 y 
=
 nums2
.
length
;
 
// Length of larger array

    
int
 low 
=
 
0
;
 
// Start of binary search range

    
int
 high 
=
 x
;
 
// End of binary search range

    
while
 
(
low 
<=
 high
)
 
{

        
// Try partitioning at this point in nums1

        
int
 partitionX 
=
 
(
low 
+
 high
)
 
/
 
2
;
 
// Mid point for array1

        
// Calculate partition point for nums2 based on median position

        
int
 partitionY 
=
 
(
x 
+
 y 
+
 
1
)
 
/
 
2
 
-
 partitionX
;
 
// Ensures left half has correct number of elements

        
// Get values at partition boundaries

        
int
 maxX 
=
 
(
partitionX 
==
 
0
)
 
?
 
Integer
.
MIN_VALUE 
:
 nums1
[
partitionX 
-
 
1
]
;
 
// Max of left side in nums1

        
int
 minX 
=
 
(
partitionX 
==
 x
)
 
?
 
Integer
.
MAX_VALUE 
:
 nums1
[
partitionX
]
;
 
// Min of right side in nums1

        
int
 maxY 
=
 
(
partitionY 
==
 
0
)
 
?
 
Integer
.
MIN_VALUE 
:
 nums2
[
partitionY 
-
 
1
]
;
 
// Max of left side in nums2

        
int
 minY 
=
 
(
partitionY 
==
 y
)
 
?
 
Integer
.
MAX_VALUE 
:
 nums2
[
partitionY
]
;
 
// Min of right side in nums2

        
// Found the right partition

        
if
 
(
maxX 
<=
 minY 
&&
 maxY 
<=
 minX
)
 
{

            
// If total length is odd

            
if
 
(
(
x 
+
 y
)
 
%
 
2
 
!=
 
0
)
 
{

                
return
 
Math
.
max
(
maxX
,
 maxY
)
;
 
// Median is the max of left sides

            
}
 
else
 
{

                
// If total length is even, median is average of max of left and min of right

                
return
 
(
Math
.
max
(
maxX
,
 maxY
)
 
+
 
Math
.
min
(
minX
,
 minY
)
)
 
/
 
2.0
;

            
}

        
}
 
else
 
if
 
(
maxX 
>
 minY
)
 
{
 
// Need to move partition to left in nums1

            high 
=
 partitionX 
-
 
1
;

        
}
 
else
 
{
 
// Need to move partition to right in nums1

            low 
=
 partitionX 
+
 
1
;

        
}

    
}

    
// Should never reach here if arrays are sorted

    
throw
 
new
 
IllegalArgumentException
(
"Input arrays are not sorted"
)
;

}
}
