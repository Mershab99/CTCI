SELECT d.date, COUNT(b.booking_id) as num_bookings
FROM dates d
LEFT JOIN (
  SELECT
  	b.date,
  	b.booking_id
  FROM bookings b
  JOIN listings l ON b.listing_id = l.listing_id
  WHERE l.country = 'US'
) b ON d.date = b.date
WHERE
	d.year = 2021
	AND d.month = 7
GROUP BY
	d.date
ORDER BY
	d.date;
