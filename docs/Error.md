
# Error

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**status** | **Integer** | original HTTP error code, should be consistent with the response HTTP code | 
**code** | **String** | The error code, in screaming snake case: eg PAYLOAD_VALIDATION_ERROR | 
**message** | **String** | descriptive error message for debugging |  [optional]
**moreInfo** | **String** | link to documentation to investigate further and finding support |  [optional]
**details** | [**List&lt;ErrorDetail&gt;**](ErrorDetail.md) |  |  [optional]



